class GenericPatternDemoV2 {
    // in: <'*', 3> out: "***"
    static String repeatChar(char ch, int n) {
        if(n == 0){
            return "";
        }
        StringBuilder buff = new StringBuilder();
        for (int i=0; i < n; i++)
            buff.append(ch);
        return buff.toString();
    }

    // in: <'(', 2, ')', 2> out: "((  ))"
    static String genLine(char left, int nleft, char right, int nright, char midChar, int width ) {
        int nMid =  width - (nleft + nright);
        if (nMid < 0)
            return null;

        String left_str = repeatChar(left, nleft);
        String right_str = repeatChar(right, nright);
        String mid_char = repeatChar(midChar, nMid);

        return left_str + mid_char + right_str;
    }

    public static void main(String[] args) {
        int i = 1;
        String line;

        if (args.length < 4) {
            System.err.println("usage java GenericPatternDemoV2 <left_char> <right_char> <mid_char> width");
            return;
        }

        final int N = Integer.parseInt(args[3]);
        final char LEFT_PIXEL = args[0].charAt(0);
        final char RIGHT_PIXEL = args[1].charAt(0);
        final char MID_PIXEL = args[2].charAt(0);

        while ((line =  genLine(LEFT_PIXEL, i, RIGHT_PIXEL, i, MID_PIXEL, N)) != null) {
            System.out.println(line);
            i++;
        }

        i = N/2;
        while ((line =  genLine(LEFT_PIXEL, i, RIGHT_PIXEL, i, MID_PIXEL, N)) != null && i!= 0) {
            System.out.println(line);
            i--;
        }

        // java GenericPatternDemoV2 "*" "*" " " 20
        // java GenericPatternDemoV2 " " " " "*" 20
        // java GenericPatternDemoV2 "|" "|" "*" 20
    }
}

