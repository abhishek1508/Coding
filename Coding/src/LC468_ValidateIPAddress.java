public class LC468_ValidateIPAddress {

    public static void main(String[] args) {
        System.out.println(validIPAddress("255..255.255"));
    }

    private static String validIPAddress(String ip) {
        String validIPv4 = isValidIPv4(ip);
        return validIPv4;
    }

    private static String isValidIPv4(String IP) {
        //172.16.254.1
        if (IP.contains(".")) {
            String[] ipAddress = IP.split("\\.");
            if (ipAddress.length != 4) { return null; }
            else {
                for (String ipAddres : ipAddress) {
                    if (!ipAddres.isEmpty()) {
                        if (!isIPRangeBtw0and255(ipAddres)) {
                            return null;
                        } else if (hasLeadingZeros(ipAddres)) {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
            }
        }
        return "IPv4";
    }

    private static boolean isIPRangeBtw0and255(String input) {
        int subDomain = Integer.parseInt(input);
        return subDomain >= 0 && subDomain <= 255;
    }

    private static boolean hasLeadingZeros(String input) {
        return input.length() > 1 && input.charAt(0) == '0';
    }
}
