package happy.ladybug;

import java.util.stream.IntStream;

/**
 * def happyLadybugs(b):
    from collections import Counter
    c = Counter(b)
    for i in set(b):
        if c[i]==1 and i!='_': return 'NO'
    if '_' not in b:
        for i in range(n-1):
            if b[i]!=b[i-1] and b[i]!=b[i+1]:
                return 'NO'
    return 'YES'
 *
 */
public class HappyLadyBug {
	public static void main(String[] args) {
	//System.out.println(CanMakeAllHappy("DD__FQ_QQF"));
	//System.out.println(CanMakeAllHappy("X_Y__X"));
		//test is failing for below scenario : second Y will never have same Y on either side.
		System.out.println(CanMakeAllHappy("XYXY_Y"));
	//X_Y__X - _XY__X - _XY_X_ _
	}
	// Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
    	
    	if(IntStream.range(1,b.length()).anyMatch(i->(b.charAt(i)=='_' && b.charAt(i-1)=='_')))
    	return "NO";
    	else
    		return "YES";
    	}
    
 // O(n) solution that is meant to be readable but not super-efficient 
    // due to use of LINQ and multiple passes through inputted string.
    /* 
    
    _       -> YES
    X       -> NO
    XX      -> YES
    X_      -> NO
    XY      -> NO
    X_X     -> YES
    XYX     -> NO
    XYZ     -> NO
    _XX     -> YES
    YXX     -> NO
    X__     -> NO
    X_Y     -> NO
    XXYY    -> YES
    XXYZ    -> NO
    XYXY    -> NO
    XXXY    -> NO
    XYXX    -> NO
    X_XX    -> YES
    X__X    -> YES
    XY_X    -> NO
    X___    -> NO
    XYZZZ   -> NO
    X_XYY   -> YES
    _XY_Y   -> NO
    _XX__   -> YES
    _XXYY   -> YES
    X_XYY   -> YES
    X___X   -> YES
    X__YX   -> NO
    X_X_Y_  -> NO
    XXXYYY  -> YES 
    ____ZZ  -> YES 
    XYZYZY  -> NO
    XXYYZZ  -> YES 
    X_XYXY  -> YES (can do moves XX_YXY, XXXY_Y, XXXYY_)
    XZY_YZX -> YES (can do moves XZ_YYZX, XZZYY_X, _ZZYYXX)
    _XYYYXX -> YES (can do moves XXYYY_X, XX_YYYX, XXXYYY_)
        */
    static String CanMakeAllHappy(String s)
    {
        if (hasUnique(s)) {
            return "NO";
        }
        
        if (alreadyHappy(s)) {
            return "YES";
        }
        
        if (hasSpace(s)) {
            return "YES";
        }
        
        return "NO";
    }
    public static boolean hasUnique(String s) {
        int[] ascii = new int[26];
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != '_') {
                ascii[(int)s.charAt(i)-65]++;
            }
        }
        
        for (int i=0;i<26;i++) {
            if (ascii[i] == 1) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean alreadyHappy(String s) {
        for (int i=0;i<s.length()-1;i++) {
            if (i == 0 && s.charAt(i) != s.charAt(i+1)) {
                return false;
            }
            else if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i-1)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean hasSpace(String s) {
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '_') {
                return true;
            }
        }
        
        return false;
    }
}
