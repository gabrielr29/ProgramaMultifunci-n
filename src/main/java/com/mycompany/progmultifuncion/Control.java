package com.mycompany.progmultifuncion;

import java.awt.Image;
import java.awt.Toolkit;

public class Control{
    
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
    
    void l_unitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){
        
          double numberToConvert = 0;
          double numberConverted = 0;
          boolean doFinally = true;
          
           numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);
            
          //Transformación de metros al resto de las unidades
          
          if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 0){
                     
                numberConverted = numberToConvert*1000;
           
          }
          
          else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 1){
                  numberConverted = numberToConvert*100;

          }
          
          else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 2){
                  numberConverted = numberToConvert*10;
          }
          
          else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 4){
                   
                 numberConverted = numberToConvert/10;
          }
          
          else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 5){
              
                 numberConverted = numberToConvert/100;
          }
          
          else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 6){
               
                 numberConverted = numberToConvert/1000;

           }
          // Unidades extranjeras a metros
           else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*39.37;

           }
           else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*3.281;

           }
           else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*1.094;

           }
            else if(selectorOne.getSelectedIndex() == 3 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/1609;

           }
          
          // Conversiones de decimetros al resto de unidades
          
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 0){
                 
                 numberConverted = numberToConvert*100;
                 formatAndSetting(fieldTwo,numberConverted);    
                 
             }
          
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 1){
                 
                 numberConverted = numberToConvert*10;
                
             }
          
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 3){
                 
                 numberConverted = numberToConvert/10;
                 
             }
           
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 4){
                 
                 numberConverted = numberToConvert/100;
                 
             }
           
          else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 5){
                 
                 numberConverted = numberToConvert/1000;
                
             }
          
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 6){
                 
                 numberConverted = numberToConvert/10000;
                
           }
           // Unidades extranjeras a decimetros
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*3.937;

           }
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*0.328;

           }
           else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*0.109;

           }
            else if(selectorOne.getSelectedIndex() == 2 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/16090;

           }
          
           // Conversiones de centimetros al resto de las unidades
             
           else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 0){
                 
                 numberConverted = numberToConvert*10;
                
             }
          
            else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 2){
                 
                 numberConverted = numberToConvert/10;
                 
             }
            else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 3){
                 
                 numberConverted = numberToConvert/100;
             }
             else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 4){
                 
                 numberConverted = numberToConvert/1000;
                
             }
             else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 5){
                 
                 numberConverted = numberToConvert/10000;
               
             }
             else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 6){
                 
                 numberConverted = numberToConvert/100000;
         
             }
           // Unidades extranjeras a centimetros
           else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert/2.54;

           }
           else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert/30.48;

           }
           else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert/91.44;

           }
            else if(selectorOne.getSelectedIndex() == 1 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/160900;

           }
          
          // Conversiones de milimetros al resto de las unidades
          
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert/10;

             }
          
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert/100;
 
             }
          
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert/1000;
     
             }
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert/10000;
      
             }
            
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert/100000;
 
             }
             else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/1000000;
      
             }
           // Unidades extranjeras a milimetros
           else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert/25.4;

           }
           else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert/304.8;

           }
           else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert/914.4;

           }
            else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/1609000;

           }
          
          // Conversiones de Decámetros al resto de las unidades
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*10000;
        
             }
          
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*1000;
      
             }
          
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*100;
  
             }
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert*10;

             }
            
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert/10;
     
             }
             else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/100;
           
             }
             // Unidades extranjeras a Decametros
           else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*393.7;

           }
           else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*32.808;

           }
           else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*10.936;

           }
            else if(selectorOne.getSelectedIndex() == 4 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/160.9;

           }
       
          
          // Conversiones de Hectometros al resto de las unidades
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*100000;
   
             }
          
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*10000;
      
             }
          
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*1000;
         
             }
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert*100;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert*10;

             }
             else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/10;
         
             }
             
           // Unidades extranjeras a Hectometros
           else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*3937;

           }
           else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*328.1;

           }
           else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*109.36;

           }
            else if(selectorOne.getSelectedIndex() == 5 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/16.09;

           }
          
            // Conversiones de Kilómetros al resto de las unidades
            
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*1000000;
       
             }
          
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*100000;
    
             }
          
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*10000;
    
             }
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert*1000;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert*100;
          
             }
             else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert*10;
      
             }
            // Unidades extranjeras a Kilometros
           else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*39370;

           }
           else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*3281;

           }
           else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*1093.6;

           }
            else if(selectorOne.getSelectedIndex() == 6 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/1.609;

           }
             // Conversiones de Pulgadas al resto de las unidades
             
            else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*25.4;
       
             }
          
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*2.54;
    
             }
          
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert/3.937;
    
             }
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert/39.37;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert/393.7;
          
             }
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert/3937;
      
             }
             else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/39370;
      
             }
            // Pulgadas a Pies, Yardas y Millas
           else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert/12;

           }
           else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 9){
               
                 numberConverted = numberToConvert/36;

           }
           else if(selectorOne.getSelectedIndex() == 7 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/63360;

           }
           
           // Conversiones de Pies al resto de las unidades
             
            else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*304.8;
       
             }
          
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*30.48;
    
             }
          
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*3.48;
    
             }
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert/3.281;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert/32.808;
          
             }
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert/328.1;
      
             }
             else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/3281;
      
             }
            // Pies a Pulgadas, Yardas y Millas
           else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*12;

           }
           else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 9){
               
                 numberConverted = numberToConvert/3;

           }
           else if(selectorOne.getSelectedIndex() == 8 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/5280;

           }
           
            // Conversiones de Yardas al resto de las unidades
             
            else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*914.4;
       
             }
          
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*91.44;
    
             }
          
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*9.144;
    
             }
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert/1.094;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert/10.936;
          
             }
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert/109.4;
      
             }
             else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert/1094;
      
             }
            // Yardas a Pulgadas, Yardas y Millas
           else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*36;

           }
           else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*3;

           }
           else if(selectorOne.getSelectedIndex() == 9 && selectorTwo.getSelectedIndex() == 10){
                  numberConverted = numberToConvert/1760;

           }
           
            // Conversiones de Millas al resto de las unidades
             
            else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 0){
                 numberConverted = numberToConvert*1609000;
       
             }
          
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 1){
                 numberConverted = numberToConvert*160900;
    
             }
          
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 2){
                 numberConverted = numberToConvert*16090;
    
             }
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 3){
                 numberConverted = numberToConvert*1609;
    
             }
            
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 4){
                 numberConverted = numberToConvert*160.9;
          
             }
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 5){
                 numberConverted = numberToConvert*16.09;
      
             }
             else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 6){
                 numberConverted = numberToConvert*1.609;
      
             }
            // Millas a Pulgadas, Yardas y Pies
           else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 7){
               
                 numberConverted = numberToConvert*63360;

           }
           else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 8){
               
                 numberConverted = numberToConvert*5280;

           }
           else if(selectorOne.getSelectedIndex() == 10 && selectorTwo.getSelectedIndex() == 9){
                  numberConverted = numberToConvert*1760;

           }          
          
           else{
                 doFinally = false;
           }
           /*
                Formateando el numero convetido para que solo tenga 2 decimales y mostrandolo 
                 en el campo de texto solo si alguno de los casos se cumple.
          
          */
             if(doFinally){
                 formatAndSetting(fieldTwo,numberConverted);
             }
                
      }
    
    void temp_unitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){
        
      double numberToConvert = 0;
      double numberConverted = 0;
      boolean doFinally = true;    
          
      numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);
        
     // Grados Fahrenheit a grados Celsius y Kelvin
        
     if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 1){
                          
         numberConverted = (numberToConvert - 32) * 5/9;
             
     }
     
     else if(selectorOne.getSelectedIndex() == 0 && selectorTwo.getSelectedIndex() == 2){
         
         numberConverted = ((numberToConvert - 32) * 5/9) + 273.15;
         
     }
     
     // Grados Celsius a grados Fahrenheit y Kelvin
     
     else if(selectorOne.getSelectedIndex()==1 && selectorTwo.getSelectedIndex() == 0){
         
         numberConverted = ((numberToConvert)*9/5)+32;
         
     }
     
     else if(selectorOne.getSelectedIndex()==1 && selectorTwo.getSelectedIndex() == 2){
         
         numberConverted = (numberToConvert)+273.15;
         
     }
     
     // Grados Kelvin a grados Fahrenheit y Celsius
     
     else if(selectorOne.getSelectedIndex()==2 && selectorTwo.getSelectedIndex() == 0){
         
         numberConverted = ((numberToConvert-273.15)*9/5)+32;
                 
     }
     
     else if(selectorOne.getSelectedIndex()==2 && selectorTwo.getSelectedIndex() == 1){
         
         numberConverted = numberToConvert-273.15;
         
     }
     
     else{
        doFinally = false;     
     }
     
     if(doFinally){
        formatAndSetting(fieldTwo,numberConverted); 
     }
          
 
        
    }
    
    void weight_unitConverter(javax.swing.JTextField fieldOne, javax.swing.JTextField fieldTwo, javax.swing.JComboBox selectorOne, javax.swing.JComboBox selectorTwo){
        
      double numberToConvert = 0;
      double numberConverted = 0;
      boolean doFinally = true;   
      
      numberToConvert = fieldValidatorBasic(fieldOne, fieldTwo, selectorOne, selectorTwo);
      
      // Conversiones de gramo a kilogramo, libra, onza y el resto de las unidades
      
    if(selectorOne.getSelectedIndex()==0 && selectorTwo.getSelectedIndex() == 1){
        
        numberConverted = numberToConvert/1000;
        
    }
    
    else if(selectorOne.getSelectedIndex()==0 && selectorTwo.getSelectedIndex() == 2){
        
        numberConverted = numberToConvert/453.6;
        
    }
    
    else if(selectorOne.getSelectedIndex()==0 && selectorTwo.getSelectedIndex() == 3){
        
        numberConverted = numberToConvert/28.35;
        
    }
    
     // Conversiones de kilogramo a gramo, libra, onza y el resto de las unidades
        
    else if(selectorOne.getSelectedIndex()==1 && selectorTwo.getSelectedIndex() == 0){
        
        numberConverted = numberToConvert*1000;
        
    }    
    
    else if(selectorOne.getSelectedIndex()==1 && selectorTwo.getSelectedIndex() == 2){
        
        numberConverted = numberToConvert*2.205;
        
    }
     
    else if(selectorOne.getSelectedIndex()==1 && selectorTwo.getSelectedIndex() == 3){
        
       numberConverted = numberToConvert*35.274;
        
    }
    
    // Conversiones de  libra a gramo, kilogramo, onza y el resto de las unidades
    
    else if(selectorOne.getSelectedIndex()==2 && selectorTwo.getSelectedIndex() == 0){
        
        numberConverted = numberToConvert*453.6;
        
    }    
    
    else if(selectorOne.getSelectedIndex()==2 && selectorTwo.getSelectedIndex() == 1){
        
        numberConverted = numberToConvert/2.205;
        
    }
     
    else if(selectorOne.getSelectedIndex()==2 && selectorTwo.getSelectedIndex() == 3){
        
       numberConverted = numberToConvert*16;
        
    }
    
   // Conversiones de  onza a gramo, kilogramo, libra y el resto de las unidades
    
    else if(selectorOne.getSelectedIndex()==3 && selectorTwo.getSelectedIndex() == 0){
        
        numberConverted = numberToConvert*28.35;
        
    }    
    
    else if(selectorOne.getSelectedIndex()==3 && selectorTwo.getSelectedIndex() == 1){
        
        numberConverted = numberToConvert/35.274;
        
    }
     
    else if(selectorOne.getSelectedIndex()==3 && selectorTwo.getSelectedIndex() == 2){
        
       numberConverted = numberToConvert/16;
        
    }
    
    else{
        doFinally = false;
    }
    
    if(doFinally){
       formatAndSetting(fieldTwo,numberConverted);  
    }
    
}
   

    
}
