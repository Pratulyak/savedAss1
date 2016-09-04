package edu.unsw.comp9321;


import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.*;
/**
 * Servlet implementation class Frontpage
 */
@SuppressWarnings("unused")
@WebServlet("/Frontpage")
public class Frontpage extends HttpServlet {
	private List<Record> archives = new LinkedList<Record>();
	private List<Record> results = new ArrayList<Record>();
	private static final long serialVersionUID = 1L;
	private HashMap<String, ArrayList<Record>> archivesDictionary = new HashMap<String, ArrayList<Record>>();
	private ArrayList<Record> randomTen = new ArrayList<Record>();
	private LinkedList<Record> shoppingCart = new LinkedList<Record>();
	private LinkedList<String> previousSearches = new LinkedList<String>();

	/**
	 * @throws ParserConfigurationException
	 * @see HttpServlet#HttpServlet()
	 */
	public Frontpage() throws SAXException, IOException, ParserConfigurationException {
		super();
		this.init();

	}

	public void init() {

		try {
			File newFile = new File(
					"/home/pratulyak/workspace/Assignment1/WebContent/WEB-INF/lib/dblp.xml");
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setValidating(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document docu = builder.parse(newFile);
			this.handleDoc(docu);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void handleDoc(Document doc) {
		System.out.print("this is running");
		for (int l = 0; l <= 20000; l++) {
			NodeList nlArticles = doc.getElementsByTagName("article");
			for (int j = 0; j < nlArticles.getLength(); j++) {
				Element el = (Element) nlArticles.item(j);
				String title = "";
				if (el.getElementsByTagName("title").item(0) != null) {
					title = el.getElementsByTagName("title").item(0).getTextContent();
				}
				ArrayList<String> authors = new ArrayList<String>();
				if (el.getElementsByTagName("author").item(0) != null) {
					for (int k = 0; k < el.getElementsByTagName("author").getLength(); k++) {
						authors.add(el.getElementsByTagName("author").item(k).getTextContent());
					}

				}
				String pages = "";
				if (el.getElementsByTagName("pages").item(0) != null) {
					pages = el.getElementsByTagName("pages").item(0).getTextContent();
				}
				String year = "";
				String volume = "";
				String journal = "";
				String number = "";
				if (el.getElementsByTagName("year").item(0) != null) {
					year = el.getElementsByTagName("year").item(0).getTextContent();
				}
				if (el.getElementsByTagName("volume").item(0) != null) {
					volume = el.getElementsByTagName("volume").item(0).getTextContent();
				}
				if (el.getElementsByTagName("journal").item(0) != null) {
					journal = el.getElementsByTagName("journal").item(0).getTextContent();
				}
				if (el.getElementsByTagName("number").item(0) != null) {
					number = el.getElementsByTagName("number").item(0).getTextContent();
				} else {
					number = "";
				}
				String ee = "";
				if (el.getElementsByTagName("ee").item(0) != null) {
					ee = el.getElementsByTagName("ee").item(0).getTextContent();
				}
				String url = el.getElementsByTagName("url").item(0).getTextContent();
				String publisher = "";
				String isbn = "";
				Record rec = new Record(title, publisher, year, pages, isbn, ee, "article", authors, journal, number,
						url);
				this.archives.add(rec);

				if (!archivesDictionary.containsKey(rec.getsearchKey())) {
					String temp = rec.getsearchKey();
					temp.toLowerCase();
					archivesDictionary.put(temp, new ArrayList<Record>());
					archivesDictionary.get(temp).add(rec);
				}
				System.out.println("test");
				
			}
			System.out.println(l);
			System.out.println("test");
			NodeList nlArtic = doc.getElementsByTagName("proceedings");
			System.out.println("this is size of nlartic " + nlArtic.getLength());
			for (int k = 0; k < nlArtic.getLength(); k++) {
				Element el = (Element) nlArtic.item(k);
				if (el.getElementsByTagName("title").item(0) != null) {
					String title = el.getElementsByTagName("title").item(0).getTextContent();
					System.out.println("this is working title = " + title);
				}
			}
			/*
			 * j = 0; j < nlArticles.getLength(); j++) { Element el = (Element)
			 * nlArticles.item(j); String title = ""; if
			 * (el.getElementsByTagName("title").item(0) != null) { title =
			 * el.getElementsByTagName("title").item(0).getTextContent(); }
			 * ArrayList<String> authors = new ArrayList<String>(); if
			 * (el.getElementsByTagName("editor").item(0) != null) { for (int k
			 * = 0; k < el.getElementsByTagName("author").getLength(); k++) {
			 * authors.add(el.getElementsByTagName("author").item(k).
			 * getTextContent()); }
			 * 
			 * } String pages = ""; if (el.getElementsByTagName("pages").item(0)
			 * != null) { pages =
			 * el.getElementsByTagName("pages").item(0).getTextContent(); }
			 * String year = ""; String volume = ""; String journal = ""; String
			 * number = ""; if (el.getElementsByTagName("year").item(0) != null)
			 * { year =
			 * el.getElementsByTagName("year").item(0).getTextContent(); } if
			 * (el.getElementsByTagName("volume").item(0) != null) { volume =
			 * el.getElementsByTagName("volume").item(0).getTextContent(); } if
			 * (el.getElementsByTagName("journal").item(0) != null) { journal =
			 * el.getElementsByTagName("journal").item(0).getTextContent(); } if
			 * (el.getElementsByTagName("number").item(0) != null) { number =
			 * el.getElementsByTagName("number").item(0).getTextContent(); }
			 * else { number = ""; } String ee = ""; if
			 * (el.getElementsByTagName("ee").item(0) != null) { ee =
			 * el.getElementsByTagName("ee").item(0).getTextContent(); } String
			 * url = el.getElementsByTagName("url").item(0).getTextContent();
			 * String publisher = ""; String isbn = ""; Record rec = new
			 * Record(title, publisher, year, pages, isbn, ee, "article",
			 * authors, journal, number, url);
			 * 
			 * } }
			 */
		}
		System.out.println("Size of list " + this.archives.size() + " dict " + this.archivesDictionary.size());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// this.doPost(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/frontpage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		String action = request.getParameter("action");
		String doAction = "";
		// String action = request.getParameter("home");
		if (action.equalsIgnoreCase("Home")) {
			doAction = "frontpage.jsp";
		} else if (action.equalsIgnoreCase("search")) {

			this.results = this.searchForFile(request);
			request.setAttribute("results", this.results);
			doAction = "searchResult.jsp";
		} else if (action.equalsIgnoreCase("add")) {
			this.addToCart(request);
		}
		// request.setAttribute("random", this.randomTen);
		request.setAttribute("shoppingCart", this.archivesDictionary);
		request.setAttribute("archives", this.randomTen);
		RequestDispatcher rd = request.getRequestDispatcher("/" + doAction);
		rd.forward(request, response);
	}

	public ArrayList<Record> searchForFile(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		this.previousSearches.add(searchString);
		searchString.toLowerCase();
		System.out.println(searchString);
		ArrayList<Record> results = new ArrayList<Record>();
		Pattern p = Pattern.compile(searchString);
		Matcher m = p.matcher(searchString);
		for (HashMap.Entry<String, ArrayList<Record>> entry : archivesDictionary.entrySet()) {
			if (entry.getKey().contains((searchString))) {
				results.addAll(entry.getValue());
			}
		}
		System.out.println(results.size());
		return results;
	}

	// VT4358904

	public void addToCart(HttpServletRequest req) {
		String record = req.getParameter("recordToAdd");

	}

	public void removeFromCart(HttpServletRequest req) {
		/*
		 * String toRemove = req.getParameter("recordToRemove");
		 * 
		 * for (Record entry : this.shoppingCart) { if
		 * (entry.getKey().contains(toRemove)) {
		 * this.shoppingCart.remove(entry); } }
		 */
	}
}
