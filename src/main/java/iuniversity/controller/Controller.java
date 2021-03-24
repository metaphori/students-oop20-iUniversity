package iuniversity.controller;

import iuniversity.view.View;

public interface Controller {
    
    View getView();
    
    void setView(View view);

}
