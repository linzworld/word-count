package Const;

/**
 * @Description 匹配字符串
 * @Author 林泽鸿
 * @Date 2020/3/24 20:12
 */
public class RegexConst {

    public static final String WORD_REGEX ="\\b[a-zA-Z]+\\b";

    public static final String nullLineRegex = "(\\s*)([{};])(\\s*)";

    public static final String Single_Line_Note_REGEX="(\\s*)([{};]?)(\\s*)(//)(.*)";
    public static final String Block_Note_Start_REGEX="(\\s*)([{};]?)(\\s*)(/{1})(\\*{1})(.*)";
    public static final String Block_Note_End_REGEX="(.*)(\\*{1})(/{1})(\\s*)";
}
