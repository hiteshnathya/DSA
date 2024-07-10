package Assignment.Day8;

class BoyeMooreAlgorithm {
    static int NO_OF_CHARS = 256;

    static int max (int a, int b)
    {
        return (a > b)? a: b;
    }      //returns max of two numbers

    static void badCharHeuristic( char []str, int size,int badchar[])
    {
        System.out.println("Computing bad character heuristic...");

        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
        {
            badchar[i] = -1;
//        System.out.print(i + ": " + badchar[i] + " ");
        }

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < size; i++)
        {
            badchar[(int) str[i]] = i;
//        System.out.print(i + ": " + badchar[i] + " ");
        }

    }

    static void search( char txt[], char pat[])
    {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

        badCharHeuristic(pat, m, badchar);

        int s = 0;
        while(s <= (n - m))
        {
            int j = m-1;
            System.out.println("Shift: " + s);
            System.out.print("Pattern: ");
            System.out.print("Text: ");
            for (int k = 0; k < n; k++) {
                System.out.print(txt[k] + " ");

            }
            System.out.println();
            System.out.println();

		/* Keep reducing index j of pattern while
			characters of pattern and text are
			matching at this shift s */
            while(j >= 0 && pat[j] == txt[s+j])
                j--;
            System.out.println("Matching at position " + j);


		/* If the pattern is present at current
			shift, then index j will become -1 after
			the above loop */

            if (j < 0) {
                System.out.println("Pattern found at shift " + s);
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
            } else {
                System.out.println("Pattern not found at shift " + s);
                s += max(1, j - badchar[txt[s + j]]);
            }
        }
    }

    public static void main(String []args) {
        char txt[] = "Hii i am Jack".toCharArray();
        char pat[] = "am".toCharArray();
        search(txt, pat);
    }
}