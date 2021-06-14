package ordunio.maribel.asignacion04_calculadoraimc_orduno


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById<EditText>(R.id.peso)
        val estatura: EditText = findViewById(R.id.estatura) as EditText
        val calcular: Button = findViewById(R.id.calcular) as Button
        val resultado: TextView= findViewById(R.id.resultado) as TextView
        val rango: TextView= findViewById(R.id.rango) as TextView

        resultado.visibility = View.INVISIBLE
        rango.visibility = View.INVISIBLE

        fun reset(){
            peso.setText("")
            estatura.setText("")
        }

        calcular.setOnClickListener {

            val p: Float = peso.text.toString().toFloat()
            val a: Float = estatura.text.toString().toFloat()
            val imc: Float = p/(a*a)

            /*Si entra a este if pero al hacer la prueba con los campos vacios truena la app*/
            if(peso.text.equals("") && estatura.text.equals("")){
                resultado.visibility = View.VISIBLE
                resultado.setText("No se ingresaron los valores, intente de nuevo")

            }else{
                resultado.visibility = View.VISIBLE
                rango.visibility = View.VISIBLE

                resultado.setText(imc.toString())

                if(imc < 18.5){
                    rango.setBackgroundResource(R.color.colorGreenish)
                    rango.setText("Bajo peso")

                }else if(imc >= 18.5 && imc <= 24.9){
                    rango.setText("Normal")
                    rango.setBackgroundResource(R.color.colorGreen)

                }else if(imc>= 25 && imc <= 29.9 ){
                    rango.setText("Sobrepeso")
                    rango.setBackgroundResource(R.color.colorYellow)

                }else if(imc >= 30 && imc <= 34.9 ){
                    rango.setText("Obesidad grado 1")
                    rango.setBackgroundResource(R.color.colorOrange)

                }else if(imc >= 35 && imc <= 39.9){
                    rango.setText("Obesidad grado 2")
                    rango.setBackgroundResource(R.color.colorRed)

                }else if(imc >= 40){
                    rango.setText("Obesidad grado 3")
                    rango.setBackgroundResource(R.color.colorBrown)
                }
            }

            reset()
        }
    }





}