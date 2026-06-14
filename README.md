--------------
**CALCULATOR**
--------------


# Descrizione delle funzionalita della calcolatrice

*my calculator has different buttons and features attached to them such as:

* CA (clear all): it is used to delete everything that had been written up to that moment and be able to start writing again


```java
bCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvStorico.setText("");
                tvInput.setText("");
                num1 = 0;
                num2 = 0;
                operazione = "";
            }
        });

```


* √ (square root): it calculates the square root of the number entered inside the symbol

```java
bRadice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().isEmpty()) {
                    return;
                }
                num1 = Float.parseFloat(tvInput.getText().toString());
                operazione = "√";
                tvStorico.setText(tvInput.getText().toString() + " √");
                tvInput.setText("");

            }
        });
```

* ^ (power): it is used to calculate the power of the first number by the second
```java
bPotenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().isEmpty()) {
                    return;
                }
                num1 = Float.parseFloat(tvInput.getText().toString());
                operazione = "^";
                tvStorico.setText(tvInput.getText().toString() + " ^");
                tvInput.setText("");
            }
        });
```


* % (percentage): it is used to calculate the percentage of the first number using the second as percentage


```java
bPercento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvInput.getText().toString().isEmpty()) {
                    return;
                }
                num1 = Float.parseFloat(tvInput.getText().toString());
                operazione = "%";
                tvStorico.setText(tvInput.getText().toString() + " %");
                tvInput.setText("");
            }
        });
```


* , (decimal point): it is used to make numbers with decimals and be able to do all the available operations with decimal numbers

```java
bVirgola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String attuale = tvInput.getText().toString();
                if (!attuale.contains(".")) {
                    if (attuale.isEmpty()) {
                        tvInput.setText("0.");
                    } else {
                        tvInput.setText(attuale + ".");
                    }
                }
            }
        });
 ```
 * = (equals): it returns the result of the performed operation

```java
bUguale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().toString().isEmpty()) {
                    num2 = Float.parseFloat(tvInput.getText().toString());
                    String operazioneCompleta = tvStorico.getText().toString() + " " + num2 + " =";
                    tvStorico.setText(operazioneCompleta);
                    eseguiCalcolo();
                }
            }
        });
 ```

* x + - / * : the classic operations needed in a calculator

```java
 bPiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparaOperatore("+");
            }
        });
 ```
 the code is the same for all four fundamental operators but only the string inside **preparaOperatore** changes

* this function is used to recognize the chosen operator and consequently perform the correct operation


```java
 private void eseguiCalcolo() {
        float ris = 0;
        if (operazione.equals("+")) {
            ris = num1 + num2;
        } else if (operazione.equals("-")) {
            ris = num1 - num2;
        } else if (operazione.equals("x")) {
            ris = num1 * num2;
        } else if (operazione.equals("/")) {
            ris = num1 / num2;
        } else if (operazione.equals("√")) {
            ris = (float) Math.pow(num2, 0.5);
        } else if (operazione.equals("^")) {
            ris = (float) Math.pow(num1, num2);
        } else if (operazione.equals("%")) {
            if (num2 == 0) {
                ris = num1 / 100;
            } else {
                ris = num1 * (num2 / 100);
            }
        }
        tvStorico.setText(String.valueOf(ris));
        tvInput.setText("");
    }
```
# Here is how it looks

![](https://cdn.hackclub.com/019ec675-542d-7f3f-922b-76745f2de379/calcolatrice_screen.jpeg)


# Choice of font and colors
I chose this particular font called **dot_digital7** with a pixelated style because I like it a lot and, in my opinion, it matched well with my choice of colors, which are purple together with some shades of gray.

## How to Install

Download the executable file from repository or visit the itch.io page and download the game from there.

link:

# License

This project is proprietary software.
The repository is public for portfolio and viewing purposes only.
Unauthorized use, reproduction, or redistribution is prohibited.
