package com.furucasper.eastersunday;

class EasterSunday {
    private int y;

    EasterSunday (int year){
        y = year;
    }

    String check(){
        String month;
        int a,b,c,d,e,h,g,k,j,m,n,r,p;
        a = y%19;
        b = y/100;
        c = y%100;
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
        switch (n){
            case 1 : month = "January";break;
            case 2 : month = "February";break;
            case 3 : month = "March";break;
            case 4 : month = "April";break;
            case 5 : month = "May";break;
            case 6 : month = "June";break;
            case 7 : month = "July";break;
            case 8 : month = "August";break;
            case 9 : month = "September";break;
            case 10 : month = "October";break;
            case 11 : month = "November";break;
            case 12 : month = "December";break;
            default: month = "Error";
        }
        return month+" "+p;

    }

}
