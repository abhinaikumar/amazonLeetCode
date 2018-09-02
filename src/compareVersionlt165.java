public class compareVersionlt165 {

    /*
    165. Compare Version Numbers
    Compare two version numbers version1 and version2.
    If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

    You may assume that the version strings are non-empty and contain only digits and the . character.
    The . character does not represent a decimal point and is used to separate number sequences.
    For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
    revision of the second first-level revision.

    Input: version1 = "0.1", version2 = "1.1"
    Output: -1
    Input: version1 = "1.0.1", version2 = "1"
    Output: 1
    Input: version1 = "7.5.2.4", version2 = "7.5.3"
    Output: -1

    */

    /*
    first approach: convert two string to string array, spilt by .
     */
    public static int compareVersion(String version1, String version2) {

        String[] digits1=version1.split("\\."); //split("[.]") also works
        String[] digits2=version2.split("\\.");
        int length=digits1.length<=digits2.length?digits2.length:digits1.length;
        for(int i=0; i<length; i++){
            Integer digit1 = i<digits1.length ? Integer.parseInt(digits1[i]):0;
            Integer digit2 = i<digits2.length ? Integer.parseInt(digits2[i]):0;
            if(digit1.compareTo(digit2)<0){
                return 1;
            }
            if(digit1.compareTo(digit2)>0){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1="7.5.2.4";
        int a=compareVersion(s1, null);
        System.out.println(a);
    }
}
