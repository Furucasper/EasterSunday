package com.furucasper.eastersunday;

class EasterSunday {
    private final int Y;

    EasterSunday (int year){
        Y = year;
    }

    String check(){
        int a,b,c,d,e,h,g,k,j,m,n,r,p;
        a = Y%19;
        b = Y/100;
        c = Y%100;
        d = b/4;
        e = b%4;
        g = (8*b+13)/25;
        h = (19*a+b-d-g+15)%30;
        j = c/4;
        k = c%4;
        m = (a+11*h)/319;
        r = (2*e+2*j-k-h+m+32)%7;
        n = (h-m+r+90)/25;
        p = (h-m+r+n+19)%32;

        final String[] MONTH = {"January","February","March","April","May","June"//
        ,"July","August","September","October","November","December"};

        return MONTH[n-1]+" "+p;
    }
}
