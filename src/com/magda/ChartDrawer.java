package com.magda;

/**
 * Created by magdgar on 2016-03-31.
 */
public class ChartDrawer {
    int[] results;
    int[] pom;

    public ChartDrawer(int[] table){
        results = table;
        pom = new int[10];
    }

    public void drawChart(){
        System.out.println(getChartAsString());
    }

    public String getChartAsString(){
        makeHelpTable();
        String result = "Y\n^\n";
        for(int i=0; i< 10; i++)
            result += generateLine(i) + "\n";

        return result;
    }

    private String generateLine(int i){
        String line = getProperBeginingSymbol(i);
        for (int j = 0; j < 10; j++)
            line += getNextLineSymbol(i,j);

        line += getProperLineEnding(i);
        return line;
    }

    private String getProperLineEnding(int i){
        return (i==4)? "--------------> X": "";
    }

    private String getNextLineSymbol(int i, int j){
        return (-pom[j] + 4 == i)? getProperSign(results[j]): (j != 0)? getProperEmptySpaceSymbol(i): "";
    }

    private String getProperBeginingSymbol(int i){
        return (i == 4)? "" : "|";
    }

    private String getProperEmptySpaceSymbol(int i){
        return (i == 4)? "--": " ";
    }

    private void makeHelpTable(){
        pom[0]= 0;
        for(int i=1;i<10;i++)
            if(results[i-1]==0)
                onZeroAction(i);
            else
                onTrendChangesAction(i);
    }
    private void onZeroAction(int i){
        pom[i]= pom[i-1] + results[i];
    }

    private void onTrendChangesAction(int i){
        if (results[i-1]==-1 && results[i]==1 || results[i-1]==1 && results[i]==-1)
            trendChangedAction(i);
        else
            trendUnchangedAction(i);
    }

    private void trendChangedAction(int i){
        pom[i]=pom[i-1];
    }

    private void trendUnchangedAction(int i){
        pom[i]= pom[i-1] + results[i-1];
    }

    private String getProperSign(int i){
        return (i==0)? "_": (i==-1)?"\\": "/";
    }
}
