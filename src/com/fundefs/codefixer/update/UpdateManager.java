package com.fundefs.codefixer.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.fundefs.codefixer.Main;

public class UpdateManager {

	public static boolean versionIsNewest() {
		String result = "";
		try {
			URL versionSite = new URL("https://raw.githubusercontent.com/FunDefs/JavaCodeFixer/master/VERSION.md");
			BufferedReader urlReader = new BufferedReader(new InputStreamReader(versionSite.openStream()));
			result = urlReader.readLine();
			urlReader.close();
		} catch (Exception e) {}
		if(result.equalsIgnoreCase("")) {
			System.out.println("Can't load the newest application version from internet.");
			return true;
		}
		
		if(new Integer(result.toCharArray()[0]) > new Integer(Main.version.toCharArray()[0])) return false;
		if(new Integer(result.toCharArray()[2]) > new Integer(Main.version.toCharArray()[2])) return false;
		if(new Integer(result.toCharArray()[4]) > new Integer(Main.version.toCharArray()[4])) return false;
		if(new Integer(result.toCharArray()[6]) > new Integer(Main.version.toCharArray()[6])) return false;
		return true;

	}

	public static void openUpdateWindow() {

	}

}
