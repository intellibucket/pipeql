package com.intellibucket.pipeql.lib.panel.stateful;


import com.intellibucket.pipeql.mgui.State;

public class StatefulGPanel <S extends State>{
    private S state;

    {
        //register MGUI
    }

    //Ekranda deyisiklik olandan sonra Panel cagirir bunu.
    public void setState(S state){
        this.state = state;
        this.publish();
    }

    //Kenarda bir deyisiklik olanda bu cagrilir
    public void consume(S state){
        this.state = state;
    }

    // Publish state to MGUI
    public void publish(){

    }


}
