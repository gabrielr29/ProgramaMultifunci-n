package com.mycompany.progmultifuncion;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;



public class Control{
	
	//Variable para controlar qué tipo de conversión se hará
	public static int buttonControler = 1;
	
    
  public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
    return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
}
    
    void numberValidator(java.awt.event.KeyEvent event, javax.swing.JTextField field){
        char caracter = event.getKeyChar();
        /* 
          Se valida que el caracter no sea diferente de los numeros ni sea un espacio en blacno
            y que no empiece la cifra con ".", para evitar errores de conversión.      
        */
        
        if((caracter<'0' || caracter>'9') && caracter != java.awt.event.KeyEvent.VK_BACK_SPACE && (caracter != '.') && (caracter !='-')){
           event.consume();
        }else if((field.getText().contains(".") && caracter == '.') || (field.getText().contains("-") && caracter == '-')){
           event.consume();
           
        }else if( field.getText().startsWith(".") ||(field.getText().contains("-") && !field.getText().startsWith("-"))){
        
           event.consume();
           field.setText("");
        }
        else if(field.getText().length()>10){
            event.consume();
        }
           
    }
    
    void formatAndSetting(javax.swing.JTextField fieldTwo, double numberConverted){
        numberConverted = formatearDecimales(numberConverted, 7);
        fieldTwo.setText(String.valueOf(numberConverted));
    }
    
    double fieldValidatorBasic(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){
         
         double numberToConvert = 0;
                
        // Validacion repetida en todos los casos de unidades
          
          if(!fieldOne.getText().isBlank()){
           numberToConvert = Double.parseDouble(fieldOne.getText());   
          }
                   
          
          if(numberToConvert == 0 || fieldOne.getText().isBlank()){
             fieldTwo.setText("0");       
          }
          
                               
          else if(selectorOne.getSelectedItem().equals(selectorTwo.getSelectedItem())){
              fieldTwo.setText(fieldOne.getText());
          }
        
        return numberToConvert;
        
        
    }
    
    void lUnitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){

        double numberToConvert = 0;
        double numberConverted = 0;
        boolean doFinally = true;

        numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);

        switch(selectorOne.getSelectedIndex()) {

            case 0: // Milímetros (mm)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert; break; // mm a mm
                    case 1: numberConverted = numberToConvert / 10; break; // mm a cm
                    case 2: numberConverted = numberToConvert / 100; break; // mm a dm
                    case 3: numberConverted = numberToConvert / 1000; break; // mm a m
                    case 4: numberConverted = numberToConvert / 10000; break; // mm a dam
                    case 5: numberConverted = numberToConvert / 100000; break; // mm a hm
                    case 6: numberConverted = numberToConvert / 1000000; break; // mm a km
                    case 7: numberConverted = numberToConvert / 25.4; break; // mm a pulgadas
                    case 8: numberConverted = numberToConvert / 304.8; break; // mm a pies
                    case 9: numberConverted = numberToConvert / 914.4; break; // mm a yardas
                    case 10: numberConverted = numberToConvert / 1609000; break; // mm a millas
                    default: doFinally = false; break;
                }
                break;

            case 1: // Centímetros (cm)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 10; break; // cm a mm
                    case 1: numberConverted = numberToConvert; break; // cm a cm
                    case 2: numberConverted = numberToConvert / 10; break; // cm a dm
                    case 3: numberConverted = numberToConvert / 100; break; // cm a m
                    case 4: numberConverted = numberToConvert / 1000; break; // cm a dam
                    case 5: numberConverted = numberToConvert / 10000; break; // cm a hm
                    case 6: numberConverted = numberToConvert / 100000; break; // cm a km
                    case 7: numberConverted = numberToConvert / 2.54; break; // cm a pulgadas
                    case 8: numberConverted = numberToConvert / 30.48; break; // cm a pies
                    case 9: numberConverted = numberToConvert / 91.44; break; // cm a yardas
                    case 10: numberConverted = numberToConvert / 160900; break; // cm a millas
                    default: doFinally = false; break;
                }
                break;

            case 2: // Decímetros (dm)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 100; break; // dm a mm
                    case 1: numberConverted = numberToConvert * 10; break; // dm a cm
                    case 2: numberConverted = numberToConvert; break; // dm a dm
                    case 3: numberConverted = numberToConvert / 10; break; // dm a m
                    case 4: numberConverted = numberToConvert / 100; break; // dm a dam
                    case 5: numberConverted = numberToConvert / 1000; break; // dm a hm
                    case 6: numberConverted = numberToConvert / 10000; break; // dm a km
                    case 7: numberConverted = numberToConvert * 3.937; break; // dm a pulgadas
                    case 8: numberConverted = numberToConvert * 0.328; break; // dm a pies
                    case 9: numberConverted = numberToConvert * 0.109; break; // dm a yardas
                    case 10: numberConverted = numberToConvert / 16090; break; // dm a millas
                    default: doFinally = false; break;
                }
                break;

            case 3: // Metros (m)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 1000; break; // m a mm
                    case 1: numberConverted = numberToConvert * 100; break; // m a cm
                    case 2: numberConverted = numberToConvert * 10; break; // m a dm
                    case 3: numberConverted = numberToConvert; break; // m a m
                    case 4: numberConverted = numberToConvert / 10; break; // m a dam
                    case 5: numberConverted = numberToConvert / 100; break; // m a hm
                    case 6: numberConverted = numberToConvert / 1000; break; // m a km
                    case 7: numberConverted = numberToConvert * 39.37; break; // m a pulgadas
                    case 8: numberConverted = numberToConvert * 3.281; break; // m a pies
                    case 9: numberConverted = numberToConvert * 1.094; break; // m a yardas
                    case 10: numberConverted = numberToConvert / 1609; break; // m a millas
                    default: doFinally = false; break;
                }
                break;

            case 4: // Decámetros (dam)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 10000; break; // dam a mm
                    case 1: numberConverted = numberToConvert * 1000; break; // dam a cm
                    case 2: numberConverted = numberToConvert * 100; break; // dam a dm
                    case 3: numberConverted = numberToConvert * 10; break; // dam a m
                    case 4: numberConverted = numberToConvert; break; // dam a dam
                    case 5: numberConverted = numberToConvert / 10; break; // dam a hm
                    case 6: numberConverted = numberToConvert / 100; break; // dam a km
                    case 7: numberConverted = numberToConvert * 393.7; break; // dam a pulgadas
                    case 8: numberConverted = numberToConvert * 32.808; break; // dam a pies
                    case 9: numberConverted = numberToConvert * 10.936; break; // dam a yardas
                    case 10: numberConverted = numberToConvert / 160.9; break; // dam a millas
                    default: doFinally = false; break;
                }
                break;

            case 5: // Hectómetros (hm)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 100000; break; // hm a mm
                    case 1: numberConverted = numberToConvert * 10000; break; // hm a cm
                    case 2: numberConverted = numberToConvert * 1000; break; // hm a dm
                    case 3: numberConverted = numberToConvert * 100; break; // hm a m
                    case 4: numberConverted = numberToConvert * 10; break; // hm a dam
                    case 5: numberConverted = numberToConvert; break; // hm a hm
                    case 6: numberConverted = numberToConvert / 10; break; // hm a km
                    case 7: numberConverted = numberToConvert * 3937; break; // hm a pulgadas
                    case 8: numberConverted = numberToConvert * 328.1; break; // hm a pies
                    case 9: numberConverted = numberToConvert * 109.36; break; // hm a yardas
                    case 10: numberConverted = numberToConvert / 16.09; break; // hm a millas
                    default: doFinally = false; break;
                }
                break;

            case 6: // Kilómetros (km)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 1000000; break; // km a mm
                    case 1: numberConverted = numberToConvert * 100000; break; // km a cm
                    case 2: numberConverted = numberToConvert * 10000; break; // km a dm
                    case 3: numberConverted = numberToConvert * 1000; break; // km a m
                    case 4: numberConverted = numberToConvert * 100; break; // km a dam
                    case 5: numberConverted = numberToConvert * 10; break; // km a hm
                    case 6: numberConverted = numberToConvert; break; // km a km
                    case 7: numberConverted = numberToConvert * 39370; break; // km a pulgadas
                    case 8: numberConverted = numberToConvert * 3281; break; // km a pies
                    case 9: numberConverted = numberToConvert * 1093.6; break; // km a yardas
                    case 10: numberConverted = numberToConvert / 1.609; break; // km a millas
                    default: doFinally = false; break;
                }
                break;

            case 7: // Pulgadas (in)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 25.4; break; // in a mm
                    case 1: numberConverted = numberToConvert * 2.54; break; // in a cm
                    case 2: numberConverted = numberToConvert / 3.937; break; // in a dm
                    case 3: numberConverted = numberToConvert / 39.37; break; // in a m
                    case 4: numberConverted = numberToConvert / 393.7; break; // in a dam
                    case 5: numberConverted = numberToConvert / 3937; break; // in a hm
                    case 6: numberConverted = numberToConvert / 39370; break; // in a km
                    case 7: numberConverted = numberToConvert; break; // in a in
                    case 8: numberConverted = numberToConvert / 12; break; // in a ft
                    case 9: numberConverted = numberToConvert / 36; break; // in a yd
                    case 10: numberConverted = numberToConvert / 63360; break; // in a mi
                    default: doFinally = false; break;
                }
                break;

            case 8: // Pies (ft)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 304.8; break; // ft a mm
                    case 1: numberConverted = numberToConvert * 30.48; break; // ft a cm
                    case 2: numberConverted = numberToConvert * 3.048; break; // ft a dm 
                    case 3: numberConverted = numberToConvert / 3.281; break; // ft a m
                    case 4: numberConverted = numberToConvert / 32.808; break; // ft a dam
                    case 5: numberConverted = numberToConvert / 328.1; break; // ft a hm
                    case 6: numberConverted = numberToConvert / 3281; break; // ft a km
                    case 7: numberConverted = numberToConvert * 12; break; // ft a in
                    case 8: numberConverted = numberToConvert; break; // ft a ft
                    case 9: numberConverted = numberToConvert / 3; break; // ft a yd
                    case 10: numberConverted = numberToConvert / 5280; break; // ft a mi
                    default: doFinally = false; break;
                }
                break;

            case 9: // Yardas (yd)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 914.4; break; // yd a mm
                    case 1: numberConverted = numberToConvert * 91.44; break; // yd a cm
                    case 2: numberConverted = numberToConvert * 9.144; break; // yd a dm
                    case 3: numberConverted = numberToConvert / 1.094; break; // yd a m
                    case 4: numberConverted = numberToConvert / 10.936; break; // yd a dam
                    case 5: numberConverted = numberToConvert / 109.4; break; // yd a hm
                    case 6: numberConverted = numberToConvert / 1094; break; // yd a km
                    case 7: numberConverted = numberToConvert * 36; break; // yd a in
                    case 8: numberConverted = numberToConvert * 3; break; // yd a ft
                    case 9: numberConverted = numberToConvert; break; // yd a yd
                    case 10: numberConverted = numberToConvert / 1760; break; // yd a mi
                    default: doFinally = false; break;
                }
                break;

            case 10: // Millas (mi)
                switch(selectorTwo.getSelectedIndex()) {
                    case 0: numberConverted = numberToConvert * 1609000; break; // mi a mm
                    case 1: numberConverted = numberToConvert * 160900; break; // mi a cm
                    case 2: numberConverted = numberToConvert * 16090; break; // mi a dm
                    case 3: numberConverted = numberToConvert * 1609; break; // mi a m
                    case 4: numberConverted = numberToConvert * 160.9; break; // mi a dam
                    case 5: numberConverted = numberToConvert * 16.09; break; // mi a hm
                    case 6: numberConverted = numberToConvert * 1.609; break; // mi a km
                    case 7: numberConverted = numberToConvert * 63360; break; // mi a in
                    case 8: numberConverted = numberToConvert * 5280; break; // mi a ft
                    case 9: numberConverted = numberToConvert * 1760; break; // mi a yd
                    case 10: numberConverted = numberToConvert; break; // mi a mi
                    default: doFinally = false; break;
                }
                break;

            default:
                doFinally = false;
                break;
        }

        if(doFinally){
            formatAndSetting(fieldTwo, numberConverted);
        }
    }
    
    void tempUnitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){

        double numberToConvert = 0;
        double numberConverted = 0;
        boolean doFinally = true;

        numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);

        switch (selectorOne.getSelectedIndex()) {
        //Farenheit
        case 0:
            switch (selectorTwo.getSelectedIndex()) {
                case 0: // Fahrenheit a Fahrenheit
                    numberConverted = numberToConvert; 
                    break;
                case 1: // Fahrenheit a Celsius
                    numberConverted = (numberToConvert - 32) * 5/9;
                    break;
                case 2: // Fahrenheit a Kelvin
                    numberConverted = ((numberToConvert - 32) * 5/9) + 273.15;
                    break;
                default:
                    doFinally = false; 
                    break;
            }
            break;
        //Celsius
        case 1:
            switch (selectorTwo.getSelectedIndex()) {
                case 0: // Celsius a Fahrenheit
                    numberConverted = ((numberToConvert)*9/5)+32;
                    break;
                case 1: // Celsius a Celsius
                    numberConverted = numberToConvert; 
                    break;
                case 2: // Celsius a Kelvin
                    numberConverted = (numberToConvert)+273.15;
                    break;
                default:
                    doFinally = false;
                    break;
            }
            break;
        //Kelvin
        case 2:
            switch (selectorTwo.getSelectedIndex()) {
                case 0: // Kelvin a Fahrenheit
                    numberConverted = ((numberToConvert-273.15)*9/5)+32;
                    break;
                case 1: // Kelvin a Celsius
                    numberConverted = numberToConvert-273.15;
                    break;
                case 2: // Kelvin a Kelvin
                    numberConverted = numberToConvert; 
                    break;
                default:
                    doFinally = false;
                    break;
            }
            break;

        default: 
            doFinally = false;
            break;
    }

        if(doFinally){
            formatAndSetting(fieldTwo,numberConverted);
        }
        
    }

    void weightUnitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){
        
      double numberToConvert = 0;
      double numberConverted = 0;
      boolean doFinally = true;   
      
      numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);
      
      // Conversiones de gramo a kilogramo, libra, onza y el resto de las unidades
      
      switch(selectorOne.getSelectedIndex()) {
      
      case 0:
    	  
    	  switch(selectorTwo.getSelectedIndex()) {
    	  
    	  //Conversiones Gramo
    	  
    	  case 0:
    		  
    		  numberConverted = numberToConvert; //Nada porque es el mismo valor.
    		  
    	  break;
    	  
    	  case 1:
    		  
    		  numberConverted = numberToConvert/1000; //Gramo
    		  
    	  break;
    	  
    	  case 2:
    		  
    		  numberConverted = numberToConvert/453.6; //Libra
    		  
    	  break;
    	  
    	  case 3:
    		  
    		  numberConverted = numberToConvert/28.35; //Onza
    		  
    	  break;
    	  
          default:
              doFinally = false;
          break;
    	  
    	  }
    	  
      break;
      
      
      case 1:
    	  
    	  switch(selectorTwo.getSelectedIndex()) {
    	  
    	  //Conversiones de Kilogramo
    	  case 0:
    		  
    		  numberConverted = numberToConvert*1000; // Gramo
    		  
    	  break;
    	  
    	  case 1:
    		  
    		  numberConverted = numberToConvert; //Nada porque es el mismo valor.
    	  
    	  case 2: 
    		  
    		  numberConverted = numberToConvert*2.205; //Libra
    		  
    	  break;
    	  
    	  case 3:
    		  
    		  numberConverted = numberToConvert*35.274; //Onza
    	  
    	  break;    	 
    	  
          default:
        	  
             doFinally = false;
             
          break;
    	  
    	  }
      break;
    	  
      case 2:
    	  
    	  //Conversiones de Libra
    	 switch(selectorTwo.getSelectedIndex()) {
    	  
    	 case 0:
    		  
    		  numberConverted = numberToConvert*453.6; //Gramo
    		  
         break;	  
         
    	 case 1:
    		 
    		  numberConverted = numberToConvert/2.205; //Kilogramo
    		  
    	 break;
    	  
    	 case 2:
    		 
      		  numberConverted = numberToConvert; //Nada porque es el mismo valor.
    		  
    	 break;
    	  
    	 case 3:
    		 
    		 numberConverted = numberToConvert*16; //Onza
    		 
    	 break;
    	 
         default:
        	 
            doFinally = false;
            
         break;
        	  
    	 
    	  }
      
    	 break;
      
      case 3:
    	  //Conversiones de Onza
    	  switch(selectorTwo.getSelectedIndex()) { 
    	  
    	   case 0:
    		   
    		   numberConverted = numberToConvert*28.35;
    		   
    	   break;    	  
    	   
    	   case 1:
    		   
    		   numberConverted = numberToConvert/35.274;
    		   
    	   break;
    	  
    	   case 2:
    		   
    		   numberConverted = numberToConvert/16;
    		   
           break;
          
    	   case 3:
    		   
    		   numberConverted = numberToConvert; //Nada porque es el mismo valor.
    		   
    	   break;
    	  
           default:
         	 
           doFinally = false;
              
           break;  
    		  
    	  
    	  }
    	  
           	  
       break;
          
      default:
    	 
         doFinally = false;
         
      break;  
    	  
      }
    
    if(doFinally){
       formatAndSetting(fieldTwo,numberConverted);  
    }
    
}
    
    public static void changeDataUI(JComboBox selector1, JComboBox selector2, String conversorCase) {
    	    	
    	switch(conversorCase) {
    	
    	case "longitud": 
    		
    		  selector1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "milímetros", "centímetros", "decímetros", "metros", "Decámetros", "Hectómetros", "Kilómetros", "Pulgada", "Pie", "Yarda", "Milla" }));
    		  selector2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "milímetros", "centímetros", "decímetros", "metros", "Decámetros", "Hectómetros", "Kilómetros", "Pulgada", "Pie", "Yarda", "Milla" }));
    		  buttonControler = 1;
    		break;
    		
    	case "temperatura":
    		
    		   selector1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grados Fahrenheit", "Grados Celsius", "Grados Kelvin" }));
    		   selector2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grados Fahrenheit", "Grados Celsius", "Grados Kelvin" }));
    		   buttonControler = 2;
    		break;
    	
    	case "masa":
    		
    			selector1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gramos", "Kilogramos", "Libras", "Onzas" }));
    			selector2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gramos", "Kilogramos", "Libras", "Onzas" }));
    			buttonControler = 3;
    		break;
    	
    	default:
    		
    		break;    	
    		
    	}
    	
    	
    		
    		
    	
    	
    	
    }
   

    
}
