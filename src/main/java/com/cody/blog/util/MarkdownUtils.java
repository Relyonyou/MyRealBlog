package com.cody.blog.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * @author Cody
 * @date 2020/11/20 - 17:59
 */
public class MarkdownUtils {

    public static String markdownToHtml(String markdown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成]
     * Markdown转化成HTML
     * @methodname markdownToHtmlExtensions
     * @param
     * @param markdown
     * @return java.lang.String
     */
    public static String markdownToHtmlExtensions(String markdown){
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(tableExtension).build();
        Node document =parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(headingAnchorExtensions).extensions(tableExtension).attributeProviderFactory(new AttributeProviderFactory() {
            @Override
            public AttributeProvider create(AttributeProviderContext context) {
                return new CustomAttributeProverder();
            }
        }).build();
        return renderer.render(document);
    }

    static class CustomAttributeProverder implements AttributeProvider{
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attribute) {
            if (node instanceof Link){
                attribute.put("target","_blank");
            }
            if (node instanceof TableBlock){
                attribute.put("class","ui celled table");
            }
        }
    }


}
