package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private static double minBal = 5000;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance, minBal);
        this.tradeLicenseId = tradeLicenseId;
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance <minBal){
            throw new RuntimeException("Insufficient Balance");
        }
        validateLicenseId();

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = tradeLicenseId.length();
        boolean validId = false;
        char []arr = tradeLicenseId.toCharArray();
        int []freq = new int[26];
        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]){
                validId = false;
                break;
            }
        }
       for(int i=0; i<n; i++){
           freq[arr[i]-'a']++;
       }
       int max =0, idx =0;

       for(int i=0; i<26; i++){
           if(freq[i]> max){
               max = freq[i];
               idx = i;
           }
       }

       if(max >((n+1)/2)){
           throw new RuntimeException("Valid License can not be generated");
       }


    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
