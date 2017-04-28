/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json;

/**
 *
 * @author Statik
 */
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class Ex {

    public static void main(String[] args) throws FileNotFoundException, JSONException {
        // TODO code application logic here

        String mainType = "";
        String mainPos = "";
        String mainBkGround = "";
        String elType = "";
        String elColor = "";
        String elPadd = "";
        String elText = "";
        String elUrl = "";
        String elPadBottom = "";
        String elPadLeft = "";
        String elPadRight = "";
        String elPadTop = "";
        String sizeX = "";
        String sizeY = "";

        String footType = "";
        String footWidth = "";
        String footAlign = "";
        String footColor = "";
        String footFontSize = "";
        String footText = "";
        String headType = "";
        String headWidth = "";
        String headAlign = "";
        String headColor = "";
        String headFontWt = "";
        String headFontSize = "";
        String headText = "";
        String headTextShadow = "";
        //FileReader reader = null;
        //FileWriter fw = null;
        //BufferedWriter bw = null;
        //String footerColor = "";
        // String xSize = "";
        //String ySize = "";
        //String headerColor = "";
        //String toppMargin = "";
        //String botMargin = "";
        //String hSizeX = "";
        //String hSizeY = "";
        JSONObject jOb = new JSONObject();
        JSONArray jArr = new JSONArray();
        JSONArray jArr2 = new JSONArray();
        JSONArray jArr5 = new JSONArray();

        try {
            
            FileReader reader;
            reader = new FileReader("/Users/Jagat/Desktop/html_spec.json");
            JSONTokener token = new JSONTokener(reader);
            jOb = new JSONObject(token);
            System.out.println("Entire JSON String: " + jOb);
            

            //footer object
            String footerColor = jOb.getJSONObject("footer").getString("background");
            System.out.println("footer background  = " + footerColor);

            //footer elements array
            jArr = jOb.getJSONObject("footer").getJSONArray("elements");
            System.out.println("Footer Elements Array: " + jArr);

            //JSON object size
            JSONObject footer = jOb.getJSONObject("footer");
            JSONObject size = footer.getJSONObject("size");
            String xSize = size.getString("x");
            String ySize = size.getString("y");
            System.out.println("Footer object size X: " + xSize);
            System.out.println("Footer object size Y: " + ySize);

            // header object
            String headerColor = jOb.getJSONObject("header").getString("background");
            System.out.println("Header Background Color :" + headerColor);
            jArr2 = jOb.getJSONObject("header").getJSONArray("elements");
            System.out.println("Header  Elements Array: " + jArr2);

            //header MARGIN OBJECT
            JSONObject headerObject = jOb.getJSONObject("header");
            JSONObject headerMargin = headerObject.getJSONObject("margin");
            String toppMargin = headerMargin.getString("top");
            String botMargin = headerMargin.getString("bottom");
            System.out.println("Header top Margin: " + toppMargin);
            System.out.println("Header bottom Margin: " + botMargin);

            //header SIZE object
            JSONObject headerSize = headerObject.getJSONObject("size");
            String hSizeX = headerSize.getString("x");
            String hSizeY = headerSize.getString("y");
            System.out.println("Header Size X: " + hSizeX);
            System.out.println("Header Size Y:  " + hSizeY);

            // MAIN object 
            jArr5 = jOb.getJSONArray("main");
            System.out.println("JSON Main Array: " + jArr5);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            System.out.println("INSIDE TRY CATCH");
            FileWriter fw = new FileWriter("html_spec.html");
            BufferedWriter bw;
            bw = new BufferedWriter(fw);
            bw.write("<! DOCTYPE html>");
            bw.newLine();
            bw.write("<html>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();

            for (int i = 0; i < jArr.length(); i++) {

                if (jArr.getJSONObject(i).has("type")) {
                    footType = jArr.getJSONObject(i).getString("type");
                }
                if (jArr.getJSONObject(i).has("width")) {
                    footWidth = jArr.getJSONObject(i).getString("width");
                }
                if (jArr.getJSONObject(i).has("alignment")) {
                    footAlign = jArr.getJSONObject(i).getString("alignment");
                }
                if (jArr.getJSONObject(i).has("color")) {
                    footColor = jArr.getJSONObject(i).getString("color");
                }
                if (jArr.getJSONObject(i).has("font-size")) {
                    footFontSize = jArr.getJSONObject(i).getString("font-size");
                }
                if (jArr.getJSONObject(i).has("text")) {
                    footText = jArr.getJSONObject(i).getString("text");
                }

                if (footType == "horizontal_rule") {
                    bw.newLine();
                    bw.write("<hr>");
                    bw.newLine();
                    bw.write("width: " + footWidth + ";");
                    bw.newLine();

                } else {
                    bw.newLine();
                    bw.write("<div> " + footType + "</div> ");
                    bw.newLine();
                    bw.write("width:" + footWidth + "px;");
                    bw.newLine();
                    bw.write("text-align: " + footAlign + ";");
                    bw.newLine();
                    bw.write("color:" + footColor + ";");
                    bw.newLine();
                    bw.write("font-size: " + footFontSize + "px;");
                    bw.newLine();
                    bw.write("<p>" + footText + "</p>");
                    bw.newLine();

                }

            }

            for (int i = 0; i < jArr2.length(); i++) {

                if (jArr2.getJSONObject(i).has("type")) {
                    headType = jArr2.getJSONObject(i).getString("type");
                }
                if (jArr2.getJSONObject(i).has("alignment")) {
                    headAlign = jArr2.getJSONObject(i).getString("alignment");
                }
                if (jArr2.getJSONObject(i).has("color")) {
                    headColor = jArr2.getJSONObject(i).getString("color");
                }
                if (jArr2.getJSONObject(i).has("font-weight")) {
                    headFontWt = jArr2.getJSONObject(i).getString("font-weight");
                }
                if (jArr2.getJSONObject(i).has("font-size")) {
                    headFontSize = jArr2.getJSONObject(i).getString("font-size");
                }
                if (jArr2.getJSONObject(i).has("text")) {
                    headText = jArr2.getJSONObject(i).getString("text");
                }
                if (jArr2.getJSONObject(i).has("text-shadow")) {
                    headTextShadow = jArr2.getJSONObject(i).getString("text");
                }

                if (headTextShadow != "") {
                    bw.write("<div>" + headType + "</div>");
                    bw.newLine();
                    bw.write("text-align: " + headAlign + ";");
                    bw.newLine();
                    bw.write("color:" + headColor);
                    bw.newLine();
                    bw.write("text-shadow: " + headTextShadow + ";");
                    bw.newLine();
                    bw.write("font-size: " + headFontSize + "px;");
                    bw.newLine();
                    bw.write("<p>" + headText + "</p>");
                    bw.newLine();

                } else {
                    bw.write("<div>" + headType + "</div>");
                    bw.newLine();
                    bw.write("text-align: " + headAlign + ";");
                    bw.newLine();
                    bw.write("color:" + headColor);
                    bw.newLine();
                    bw.write("font-weight: " + headFontWt + ";");
                    bw.newLine();
                    bw.write("font-size: " + headFontSize + "px;");
                    bw.newLine();
                    bw.write("<p>" + headText + "</p>");
                    bw.newLine();

                }

            }

            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");

            for (int i = 0; i < jArr5.length(); i++) {
                if (jArr5.getJSONObject(i).has("type")) {
                    mainType = jArr5.getJSONObject(i).getString("type");
                }
                if (jArr5.getJSONObject(i).has("position")) {
                    mainPos = jArr5.getJSONObject(i).getString("position");
                }
                if (jArr5.getJSONObject(i).has("background")) {
                    mainBkGround = jArr5.getJSONObject(i).getString("background");
                }
                JSONArray jArr6 = jArr5.getJSONObject(i).getJSONArray("elements");

                for (int j = 0; j < jArr6.length(); j++) {

                    if (jArr6.getJSONObject(i).has("type")) {
                        elType = jArr6.getJSONObject(i).getString("type");
                    }
                    if (jArr6.getJSONObject(i).has("color")) {
                        elColor = jArr6.getJSONObject(i).getString("color");
                    }
                    if (jArr6.getJSONObject(i).has("padding")) {
                        elPadd = jArr6.getJSONObject(i).getJSONObject("padding").getString("left");
                    }
                    if (jArr6.getJSONObject(i).has("text")) {
                        elText = jArr6.getJSONObject(i).getString("text");
                    }
                    if (jArr6.getJSONObject(i).has("url")) {
                        elUrl = jArr6.getJSONObject(i).getString("url");
                    }

                }

                if (jArr5.getJSONObject(i).has("padding")) {
                    elPadBottom = jArr5.getJSONObject(i).getJSONObject("padding").getString("bottom");
                    elPadLeft = jArr5.getJSONObject(i).getJSONObject("padding").getString("left");
                    elPadRight = jArr5.getJSONObject(i).getJSONObject("padding").getString("right");
                    elPadTop = jArr5.getJSONObject(i).getJSONObject("padding").getString("top");
                }

                if (jArr5.getJSONObject(i).has("size")) {
                    sizeX = jArr5.getJSONObject(i).getJSONObject("size").getString("x");
                    sizeY = jArr5.getJSONObject(i).getJSONObject("size").getString("y");

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
