package tool;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    private static String readClassFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {
        try {
 
            String ossClassContent = readClassFile("D:\\thesis\\Tool_1710\\src\\dev\\OSS.java");
            
            
            String osstestClassContent = readClassFile("D:\\thesis\\Tool_1710\\src\\test\\OSSTest.java");

            
            String htmlContent = generateHTMLContent(ossClassContent);

            
            writeContentToFile(htmlContent, "index.html");

            System.out.println("HTML file 'index.html' created successfully.");
        } catch (IOException e) {
            System.err.println("Error reading file or writing to HTML: " + e.getMessage());
        }
    }

    private static String generateHTMLContent(String ossClassContent) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html>\n<head>\n");
        htmlContent.append("<title>Code Content</title>\n");
        htmlContent.append("<style>\n");
        htmlContent.append(".line-number {");
        htmlContent.append("  display: inline-block;");
        htmlContent.append("  width: 40px;");
        htmlContent.append("  text-align: right;");
        htmlContent.append("  margin-right: 10px;");
        htmlContent.append("  color: #888;");
        htmlContent.append("}\n");
        htmlContent.append(".code-line {");
        htmlContent.append("  display: inline-block;");
        htmlContent.append("  position: relative;");
        htmlContent.append("}\n");
        htmlContent.append(".hover-info {");
        htmlContent.append("  display: none;");
        htmlContent.append("  position: absolute;");
        htmlContent.append("  top: -20px;");
        htmlContent.append("  left: 100%;");
        htmlContent.append("  border: 1px solid #888;");
        htmlContent.append("  padding: 3px 5px;");
        htmlContent.append("  background-color: #f9f9f9;");
        htmlContent.append("  color: black;");
        htmlContent.append("}\n");
        htmlContent.append(".code-line:hover .hover-info {");
        htmlContent.append("  display: inline-block;");
        htmlContent.append("}\n");
        htmlContent.append("</style>\n");
        htmlContent.append("</head>\n<body>\n");
        htmlContent.append("<h1>OSS Class:</h1>\n");
        htmlContent.append("<pre>\n");

        // Append OSS class content with line numbers
        String[] ossLines = ossClassContent.split("\n");
        for (int i = 0; i < ossLines.length; i++) {
            htmlContent.append("<div class=\"code-line\">");
            htmlContent.append("<span class=\"line-number\">").append(i + 1).append("</span>");
            if (i == 8 || i == 10 || i == 11 || i == 14 || i == 15 || i == 16) {
                htmlContent.append("<span class=\"hover-info\">testLoginSuccess()</span>");
            }
            htmlContent.append(ossLines[i]);
            htmlContent.append("</div>\n");
        }

        htmlContent.append("</pre>\n");
        htmlContent.append("</body>\n</html>");
        return htmlContent.toString();
    }


    private static void writeContentToFile(String content, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}
