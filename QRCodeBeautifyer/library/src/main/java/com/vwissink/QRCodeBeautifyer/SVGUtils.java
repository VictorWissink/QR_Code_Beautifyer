package com.vwissink.QRCodeBeautifyer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SVGUtils {
    public static Element createLinearGradientElement(Document document, String startColor, String stopColor) {
        // Create and return a linear gradient element
        Element linearGradient = document.createElement("linearGradient");
        linearGradient.setAttribute("id", "backgroundGradient");
        linearGradient.setAttribute("x1", "0%");
        linearGradient.setAttribute("y1", "0%");
        linearGradient.setAttribute("x2", "100%");
        linearGradient.setAttribute("y2", "100%");
        linearGradient.appendChild(createColorStop(document, "0%", startColor));
        linearGradient.appendChild(createColorStop(document, "100%", stopColor));
        return linearGradient;
    }

    public static Element createColorStop(Document document, String offset, String color) {
        // Create and return a color stop element
        Element stop = document.createElement("stop");
        stop.setAttribute("offset", offset);
        stop.setAttribute("style", "stop-color:" + color + ";stop-opacity:1");
        return stop;
    }
}