package hash;

public class stringModify {
    public stringModify(){

    }

    public String addPadding(String s){
        int keepLenght;
        boolean ok=false,mok=false;
        keepLenght=s.length();
        if(s.length()%128!=0){
            mok = true;
            if(s.length()%128>=112){
                keepLenght=keepLenght/128;
                keepLenght=((keepLenght+1)*128)-s.length();
            }
            else{
                keepLenght=keepLenght/128;
                keepLenght=((keepLenght+1)*128)-s.length();
                ok=true;
            }
            for(int i=0;i<keepLenght;i++){
                if(i==0){
                    s= s.concat("1");
                }
                else s= s.concat("0");
            }
        }

        if(s.length()%128==0 && ok==false){
            if(mok==false){
                for(int i=0;i<128;i++){
                    if(i==0){
                        s= s.concat("1");
                    }
                    else s= s.concat("0");
                }
            }
            else{
                for(int i=0;i<128;i++){
                    s= s.concat("0");
                }
            }
        }
        return s;
    }

}
