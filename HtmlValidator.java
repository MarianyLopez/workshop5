import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

    public static void main(String[] args) throws IOException {

        Queue <HtmlTag> htmlTags = HtmlReader.getTagsFromHtmlFile("");

        Stack<HtmlTag> htmlTagStack = isValidHtml(htmlTags);

        if (htmlTagStack==null){
            System.out.println(htmlTagStack);
            System.out.println("El html no está bien formateado");
        } else if(!htmlTagStack.empty()){
            System.out.println(htmlTagStack);
            System.out.println("El html no está bien formateado");
        }else {
            System.out.println(htmlTagStack);
            System.out.println("El html está bien formateado");
        }

    }
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> htmlTags ){
        Stack <HtmlTag> htmlTagStack = new Stack<>();
        for (HtmlTag htmlTag: htmlTags) {
            if (htmlTag.isOpenTag()){
                htmlTagStack.push(htmlTag);
            }else if(!htmlTag.isSelfClosing()) {
                if (!htmlTagStack.empty()) {
                    if (htmlTag.matches(htmlTagStack.peek())) {
                        htmlTagStack.pop();
                    }else
                        return null;
                }else
                    return null;
            } else{
                if(htmlTagStack.empty()){
                    return null;
                }
            }
        }
        return htmlTagStack;
    }

}
