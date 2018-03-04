#include <String.h>
String data;

//pins status 
String sPin0;
String sPin1;
String sPin2;
String sPin3;
String sPin4;
String sPin5;
String sPin6;
String sPin7;
String sPin8;
String sPin9;
String sPin10;
String sPin11;
String sPin12;
String sPin13;
//pin data       
String pinName = "";
String pinStatus = "";
String pinValue = "";
//pin declaration
const int pin0 = 0;
const int pin1 = 1;
const int pin2 = 2;
const int pin3 = 3;
const int pin4 = 4;
const int pin5 = 5;
const int pin6 = 6;
const int pin7 = 7;
const int pin8 = 8;
const int pin9 = 9;
const int pin10 = 10;
const int pin11 = 11;
const int pin12 = 12;
//const int pin13 = 13;


void setup() {
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(LED_BUILTIN, LOW);

  pinMode(pin0,OUTPUT);
  pinMode(pin1,OUTPUT);
  pinMode(pin2,OUTPUT);
  pinMode(pin3,OUTPUT);
  pinMode(pin4,OUTPUT);
  pinMode(pin5,OUTPUT);
  pinMode(pin6,OUTPUT);
  pinMode(pin7,OUTPUT);
  pinMode(pin8,OUTPUT);
  pinMode(pin9,OUTPUT);
  pinMode(pin10,OUTPUT);
  pinMode(pin11,OUTPUT);
  pinMode(pin12,OUTPUT);
  //pinMode(pin13,OUTPUT);

  //sPins
  sPin0 = "0,OUTPUT,LOW;";
  sPin1 = "1,OUTPUT,LOW;";
  sPin2 = "2,OUTPUT,LOW;";
  sPin3 = "3,OUTPUT,LOW;";
  sPin4 = "4,OUTPUT,LOW;";
  sPin5 = "5,OUTPUT,LOW;";
  sPin6 = "6,OUTPUT,LOW;";
  sPin7 = "7,OUTPUT,LOW;";
  sPin8 = "8,OUTPUT,LOW;";
  sPin9 = "9,OUTPUT,LOW;";
  sPin10 = "10,OUTPUT,LOW;";
  sPin11 = "11,OUTPUT,LOW;";
  sPin12 = "12,OUTPUT,LOW;";
  sPin13 = "13,OUTPUT,LOW;";
  //initial data
  data = sPin2 +  sPin3 +  sPin4 +  sPin5 +  sPin6 +  sPin7 +  sPin8 +  sPin9 +  sPin10 +  sPin11 +  sPin12 + "\n";
}

//Função para ler a string
String lerStringSerial(){
  //enquanto houver caracteres
  char caractere;
  String conteudo;
  int i = 0;

  pinName = "";
  pinStatus = "";
  pinValue = "";
  
  while(Serial.available() > 0){
    
    caractere = Serial.read();
       if (caractere != '\n' && caractere != ','){
            // Concatena valores
            conteudo.concat(caractere);
           
            if(i == 0){
              pinName = conteudo;
            }else if (i == 1){
              pinStatus = conteudo;
            }else{
              pinValue = conteudo;
            }
            
       }else{
        i++;
        conteudo="";
       }
       delay(5);
       
   }  
     
  //fim while
  return conteudo;
}
//==============================================================================================Send Data  ========================================================
void sendData (){
    digitalWrite(LED_BUILTIN, HIGH);
    Serial.print(data);    
    digitalWrite(LED_BUILTIN, LOW);
  }
//==============================================================================================Receive Data ========================================================
void receiveData(){
  int pin = pinName.toInt();
  switch(pin){
//==============================================================Case 2
     case 2:
      if(pinStatus == "OUTPUT"){
        pinMode(pin2,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin2,LOW);
        }else{
          digitalWrite(pin2,HIGH);
        }
      }else{
        pinMode(pin2,INPUT);
        if(digitalRead(pin2)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin2 = "";
      sPin2 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 3
     case 3:
      if(pinStatus == "OUTPUT"){
        pinMode(pin3,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin3,LOW);
        }else{
          digitalWrite(pin3,HIGH);
        }
      }else{
        pinMode(pin3,INPUT);
        if(digitalRead(pin3)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin3 = "";
      sPin3 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 4
     case 4:
      if(pinStatus == "OUTPUT"){
        pinMode(pin4,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin4,LOW);
        }else{
          digitalWrite(pin4,HIGH);
        }
      }else{
        pinMode(pin4,INPUT);
        if(digitalRead(pin4)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin4 = "";
      sPin4 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 5
     case 5:
      if(pinStatus == "OUTPUT"){
        pinMode(pin5,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin5,LOW);
        }else{
          digitalWrite(pin5,HIGH);
        }
      }else{
        pinMode(pin5,INPUT);
        if(digitalRead(pin5)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin5 = "";
      sPin5 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 6
     case 6:
      if(pinStatus == "OUTPUT"){
        pinMode(pin6,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin6,LOW);
        }else{
          digitalWrite(pin6,HIGH);
        }
      }else{
        pinMode(pin1,INPUT);
        if(digitalRead(pin6)!=1){
          pinValue = "LOW";
        }else{
            pinValue = "HIGH";
        }
      }
      sPin6 = "";
      sPin6 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 7
     case 7:
      if(pinStatus == "OUTPUT"){
        pinMode(pin7,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin7,LOW);
        }else{
          digitalWrite(pin7,HIGH);
        }
      }else{
        pinMode(pin7,INPUT);
        if(digitalRead(pin7)!=1){
          pinValue = "LOW";
        }else{
            pinValue = "HIGH";
        }
      }
      sPin7 = "";
      sPin7 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 8
     case 8:
      if(pinStatus == "OUTPUT"){
        pinMode(pin8,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin8,LOW);
        }else{
          digitalWrite(pin8,HIGH);
        }
      }else{
        pinMode(pin8,INPUT);
        if(digitalRead(pin8)!=1){
          pinValue = "LOW";
        }else{
            pinValue = "HIGH";
        }
      }
      sPin8 = "";
      sPin8 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 9
     case 9:
      if(pinStatus == "OUTPUT"){
        pinMode(pin9,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin9,LOW);
        }else{
          digitalWrite(pin9,HIGH);
        }
      }else{
        pinMode(pin9,INPUT);
        if(digitalRead(pin9)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin9 = "";
      sPin9 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 10
     case 10:
      if(pinStatus == "OUTPUT"){
        pinMode(pin10,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin10,LOW);
        }else{
          digitalWrite(pin10,HIGH);
        }
      }else{
        pinMode(pin10,INPUT);
        if(digitalRead(pin10)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin10 = "";
      sPin10 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 11
     case 11:
      if(pinStatus == "OUTPUT"){
        pinMode(pin11,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin11,LOW);
        }else{
          digitalWrite(pin11,HIGH);
        }
      }else{
        pinMode(pin11,INPUT);
        if(digitalRead(pin11)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin11 = "";
      sPin11 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
//==============================================================Case 12
     case 12:
      if(pinStatus == "OUTPUT"){
        pinMode(pin12,OUTPUT);
        if(pinValue == "LOW"){
          digitalWrite(pin12,LOW);
        }else{
          digitalWrite(pin12,HIGH);
        }
      }else{
        pinMode(pin12,INPUT);
        if(digitalRead(pin12)!=1){
          pinValue = "LOW";
        }else{
          pinValue = "HIGH";
        }
      }
      sPin12 = "";
      sPin12 = pinName + "," + pinStatus + "," + pinValue + ";";
     break;
  }//fim switch
  toString();
}

//============================================================================================== ToString() ======================================================== 
void toString(){
  data="";
  data = sPin2 +  sPin3 +  sPin4 +  sPin5 +  sPin6 +  sPin7 +  sPin8 +  sPin9 +  sPin10 +  sPin11 +  sPin12 + "\n";
}

//============================================================================================== update data =======================================================

void updateData(){  
  int pin;

//========================== sPin 2 =======================
  splitString(sPin2);
  pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin2 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 3 =======================
  splitString(sPin3);
  pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin3 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 4 =======================
  splitString(sPin4);
  pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin4 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 5 =======================
  splitString(sPin5);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin5 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 6 =======================
  splitString(sPin6);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin6 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 7 =======================
  splitString(sPin7);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin7 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 8 =======================
  splitString(sPin8);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin8 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 9 =======================
  splitString(sPin9);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin9 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 10 =======================
  splitString(sPin10);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin10 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 11 =======================
  splitString(sPin11);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin11 = pinName + "," + pinStatus + "," + pinValue + ";";

//========================== sPin 12 =======================
  splitString(sPin12);
 pin = pinName.toInt();
  if(pinStatus == "INPUT"){
    if(digitalRead(pin)!=1){
      
      pinValue = "LOW";
   }else{
      pinValue = "HIGH";
    }
  }
  sPin12 = pinName + "," + pinStatus + "," + pinValue + ";";
  
  toString();
}

//============================================================================================== Split string =======================================================


void splitString(String spinN){
    char caractere[15];// 1,OUTPUT,LOW;
    spinN.toCharArray(caractere,15); //0-12
    int j=0;
    String palavra;
    pinName  = "";
    pinStatus= "";
    pinValue = "";
    char letra;
    for(int i = 0 ; i < 15 ; i++){
      letra = caractere[i];
      if ( letra != ';' && letra != ','){
           palavra += (String)letra;
           //Serial.print("\n" + palavra + "\n J: " + j + "\n letra: " + letra);
       }else{
        
        // Concatena valores
        if(j == 0){
          pinName = palavra;
        }else if (j == 1){
          pinStatus = palavra;
        }else if(j==2){
          pinValue = palavra;
        }
        
        j++;
        palavra = "";
       }
       
    }
}

//============================================================================================== LOOP() ============================================================
void loop() {
  
  String recebido;
  recebido = "";
    if(Serial.available() > 0){
        
        recebido = lerStringSerial();
        if(recebido == "RD"){
          updateData();
          sendData();
        }else{
          receiveData();
        }
    }
    
}


