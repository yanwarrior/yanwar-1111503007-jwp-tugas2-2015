package utilitas;

import java.util.ArrayList;

/**
 * this class use for input validation.
 * @author yanwar solahudin
 */
public class Validation {
    
    private String angkaPertama;
    private String angkaKedua;
    private ArrayList<String> validateMessage = new ArrayList<String>();
    
    public Validation(String angkaPertama, String angkaKedua) {
        this.angkaPertama = angkaPertama;
        this.angkaKedua = angkaKedua;
    }
    
    public boolean run() {
        boolean result = true;
        
        // validasi nilai kosong
        if (this.isEmpty()) {
            result = false;
            validateMessage.add("terdapat nilai inputan yang kosong");
        }
        
        // validasi lebih kecil atau sama dengan
        else if (this.isSmallerOrSame()) {
            result = false;
            validateMessage.add("nilai pertama lebih besar dari atau sama dengan nilai kedua");
        }
        
        // validasi mengandung nilai alphabet
        else if (this.isAlphabet()) {
            result = false;
            validateMessage.add("beberapa nilai mengandung unsur bukan angka");
        }
        
        return result;
    }
    
    private boolean isSmallerOrSame() {
        boolean result = false;
        if (Integer.parseInt(this.angkaPertama) > Integer.parseInt(this.angkaKedua)) {
            result = true;
        } else if (Integer.parseInt(this.angkaPertama) == Integer.parseInt(this.angkaKedua)) {
            result = true;
        }
        
        return result;
    }
    
    private boolean isEmpty() {
        boolean result = false;
        if (this.angkaPertama.length() <= 0) {
            result = true;
        } 
        
        if (this.angkaKedua.length() <= 0) {
            result = true;
        }
        return result;
    }
    
    private boolean isAlphabet() {
        boolean result = false;
        
        if (this.angkaPertama.matches(".*[a-zA-Z]+.*")) {
            result = true;
        }
        
        if (this.angkaKedua.matches(".*[a-zA-Z]+.*")) {
            result = true;
        }
        
        return result;
    }
    
    public ArrayList<String> getErrorMessage() {
        return this.validateMessage;
    }
    
    public static Validation getInstance(String angka1, String angka2) {
        return new Validation(angka1, angka2);
    }
}
