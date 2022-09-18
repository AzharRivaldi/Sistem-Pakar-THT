package com.azhar.sptht.model;

import java.io.Serializable;

/**
 * Created by Azhar Rivaldi on 29-07-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 */

public class ModelDiagnosa implements Serializable {

    String strGejala = null;
    boolean selected = false;

    public String getStrGejala() {
        return strGejala;
    }

    public void setStrGejala(String strGejala) {
        this.strGejala = strGejala;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
