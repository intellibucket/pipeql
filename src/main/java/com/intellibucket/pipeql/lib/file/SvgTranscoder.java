package com.intellibucket.pipeql.lib.file;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.TranscodingHints;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.util.SVGConstants;
import org.w3c.dom.DOMImplementation;

import java.awt.image.BufferedImage;

public class SvgTranscoder extends ImageTranscoder {

    private BufferedImage image = null;

    @Override
    public BufferedImage createImage(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        return image;
    }

    @Override
    public void writeImage(BufferedImage bufferedImage, TranscoderOutput transcoderOutput) throws TranscoderException {

    }

    public BufferedImage getImage() {
        return image;
    }


    public static class DefaultHint{

        public static TranscodingHints get(int width, int height){
            DOMImplementation domImplementation = SVGDOMImplementation.getDOMImplementation();
            TranscodingHints hints = new TranscodingHints();
            hints.put(ImageTranscoder.KEY_WIDTH, width);
            hints.put(ImageTranscoder.KEY_HEIGHT,height);
            hints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION, domImplementation);
            hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI,SVGConstants.SVG_NAMESPACE_URI);
            hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG);
            hints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, false);
            return hints;
        }
    }
}
