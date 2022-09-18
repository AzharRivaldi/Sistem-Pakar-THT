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

public class ModelDaftarPenyakit implements Serializable {

    String strKode;
    String strDaftarPenyakit;

    public String getStrKode() {
        return strKode;
    }

    public void setStrKode(String strKode) {
        this.strKode = strKode;
    }

    public String getStrDaftarPenyakit() {
        return strDaftarPenyakit;
    }

    public void setStrDaftarPenyakit(String strDaftarPenyakit) {
        this.strDaftarPenyakit = strDaftarPenyakit;
    }

}
