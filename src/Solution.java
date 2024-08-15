class Solution {
    public static int countSeniors(String[] citizens) {
        int count = 0;
        for (String citizen : citizens) {
            int tensPlace = (citizen.charAt(11) - '0') * 10;
            int onesPlace = (citizen.charAt(12) - '0');
            if (tensPlace + onesPlace > 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String citizens[] = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        System.out.println(countSeniors(citizens));
    }
}