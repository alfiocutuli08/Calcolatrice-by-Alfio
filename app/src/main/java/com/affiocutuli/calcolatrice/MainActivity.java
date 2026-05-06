package com.affiocutuli.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvStorico, tvInput;

    Button bCA, bRadice, bPotenza, bPercento;
    Button b7, b8, b9, bDiviso;
    Button b4, b5, b6, bPer;
    Button b1, b2, b3, bMeno;
    Button b0, bVirgola, bPiu, bUguale;

    float num1 = 0;
    float num2 = 0;
    String operazione = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStorico = findViewById(R.id.tvStorico);
        tvInput = findViewById(R.id.tvInput);

        bCA = findViewById(R.id.bCA);
        bRadice = findViewById(R.id.bRadice);
        bPotenza = findViewById(R.id.bPotenza);
        bPercento = findViewById(R.id.bPercento);

        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bDiviso = findViewById(R.id.bDiviso);

        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        bPer = findViewById(R.id.bPer);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        bMeno = findViewById(R.id.bMeno);

        b0 = findViewById(R.id.b0);
        bVirgola = findViewById(R.id.bVirgola);
        bPiu = findViewById(R.id.bPiu);
        bUguale = findViewById(R.id.bUguale);

        bPiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparaOperatore("+");
            }
        });

        bMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparaOperatore("-");
            }
        });
        bPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparaOperatore("x");
            }
        });
        bDiviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preparaOperatore("/");
            }
        });

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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroClick(view);
            }
        });

    }

    public void numeroClick(View view) {
        Button b = (Button) view;
        tvInput.append(b.getText().toString());
    }

    private void preparaOperatore(String op) {
        if (!tvInput.getText().toString().isEmpty()) {
            num1 = Float.parseFloat(tvInput.getText().toString());
            operazione = op;
            tvStorico.setText(num1 + " " + op);
            tvInput.setText("");
        }
    }

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
}