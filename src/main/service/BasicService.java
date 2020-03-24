package service;
import Const.RegexConst;
import util.FileUtil;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Description 基本功能的实现
 * @Author 林泽鸿
 * @Date 2020/3/20 11:52
 */
public class BasicService {

    public static int character = 0;
    public static int word = 0;
    public static int line = 0;
    public static int nullLine = 0;
    public static int codeLine = 0;
    public static int commentLine = 0;
    
    private static List<File> files = null;



    //获取文件行数
    public static void lineCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        line = 0;
        while(reader.readLine()!=null) {
            line ++;
        }
        reader.close();
    }

    //获取单词数目,单词只能匹配连续的英文字母
    public  static void  wordCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        word=0;

        String currentLine;
        Pattern pattern = Pattern.compile(RegexConst.WORD_REGEX);
        Matcher matcher;
        while((currentLine=reader.readLine())!=null) {
            currentLine=currentLine.trim();
            matcher= pattern.matcher(currentLine);
            while(matcher.find()) {
                word++;
            }
        }
        reader.close();
    }
    //获取字符数，这里的字符是包括空白字符的，所以直接使用每次读取的行字符串的长度进行累加
    public static void charCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        character=0;
        String currentLine;
        while((currentLine=reader.readLine())!=null) {
            character +=currentLine.length();
        }
        reader.close();
    }

    //空行：本行全部是空格或格式控制字符，如果包括代码，则只有不超过一个可显示的字符，例如“{”。
    public static void nullLineCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        nullLine =0;
        String currentLine;
        //使用正则表达式
        while((currentLine=reader.readLine())!=null) {
            if(currentLine.matches(RegexConst.nullLineRegex)) {
                nullLine++;
            }
        }
        reader.close();
    }


    //注释行的统计
    public static void commentLineCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        commentLine=0;
        String currentLine;
        while((currentLine=reader.readLine())!=null) {
            if(currentLine.matches(RegexConst.Single_Line_Note_REGEX)) {
                commentLine++;
            }else if(currentLine.matches(RegexConst.Block_Note_Start_REGEX)) {
                commentLine++;
                while((currentLine=reader.readLine())!=null) {
                    if(currentLine.matches(RegexConst.Block_Note_End_REGEX)) {
                        commentLine++;
                        break;
                    }else {
                        commentLine++;
                    }
                }
            }
        }
    }

    //代码行数
    public static void codeLineCount(String fileName) throws IOException {
        BufferedReader reader= FileUtil.fileWrapper(fileName);
        lineCount(fileName);
        nullLineCount(fileName);
        commentLineCount(fileName);
        codeLine = line - nullLine - commentLine;
    }
}

