package ru.rache.stringcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_0.setOnClickListener { setTextField("0") }
        button_1.setOnClickListener { setTextField("1") }
        button_2.setOnClickListener { setTextField("2") }
        button_3.setOnClickListener { setTextField("3") }
        button_4.setOnClickListener { setTextField("4") }
        button_5.setOnClickListener { setTextField("5") }
        button_6.setOnClickListener { setTextField("6") }
        button_7.setOnClickListener { setTextField("7") }
        button_8.setOnClickListener { setTextField("8") }
        button_9.setOnClickListener { setTextField("9") }
        open_bracket.setOnClickListener { setTextField("(") }
        close_bracket.setOnClickListener { setTextField(")") }
        delimiter.setOnClickListener { setTextField("/") }
        multiple.setOnClickListener { setTextField("*") }
        minus.setOnClickListener { setTextField("-") }
        plus.setOnClickListener { setTextField("+") }

        dot.setOnClickListener { setTextField(".") }

        button_ac.setOnClickListener {
            operations.text = ""
            result.text = ""
        }
        del.setOnClickListener {
            val str = operations.text.toString()

            if (str.isNotEmpty()) {
                operations.text = str.substring(0, str.length - 1)
            }
            result.text = ""
        }

        calculate.setOnClickListener {
            val str = operations.text.toString()
            var check = true

            /*for (i in 0..str.length-1)
            {
                if ((str[i] == '0')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '1')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '2')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '3')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '4')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '5')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '6')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '7')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '8')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }
                if ((str[i] == '9')&&(i != 0)) {
                    if (str[i-1] == ')') {
                        check = false
                    }
                }

                if ((str[i] == ')')&&(i != 0)) {
                    if ((str[i-1] == '(')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '+')
                        &&(str[i-1] == '-')
                        &&(str[i-1] == '*')
                        &&(str[i-1] == '/')) {
                        check = false
                    }
                }
                else if ((str[i] == ')')&&(i == 0))
                {
                    check = false
                }
                if ((str[i] == '(')&&(i != 0)) {
                    if ((str[i-1] == ')')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '0')
                        &&(str[i-1] == '1')
                        &&(str[i-1] == '2')
                        &&(str[i-1] == '3')
                        &&(str[i-1] == '4')
                        &&(str[i-1] == '5')
                        &&(str[i-1] == '6')
                        &&(str[i-1] == '7')
                        &&(str[i-1] == '8')
                        &&(str[i-1] == '9')
                        &&(str[i-1] == '7')) {
                        check = false
                    }
                }

                if ((str[i] == '/')&&(i != 0)) {
                    if ((str[i-1] == '(')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '+')
                        &&(str[i-1] == '-')
                        &&(str[i-1] == '*')
                        &&(str[i-1] == '/')) {
                        check = false
                    }
                }
                else if ((str[i] == '/')&&(i == 0))
                {
                    check = false
                }
                if ((str[i] == '*')&&(i != 0)) {
                    if ((str[i-1] == '(')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '+')
                        &&(str[i-1] == '-')
                        &&(str[i-1] == '*')
                        &&(str[i-1] == '/')) {
                        check = false
                    }
                }
                else if ((str[i] == '*')&&(i == 0))
                {
                    check = false
                }
                if ((str[i] == '+')&&(i != 0)) {
                    if ((str[i-1] == '(')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '+')
                        &&(str[i-1] == '-')
                        &&(str[i-1] == '*')
                        &&(str[i-1] == '/')) {
                        check = false
                    }
                }
                else if ((str[i] == '+')&&(i == 0))
                {
                    check = false
                }
                if ((str[i] == '-')&&(i != 0)) {
                    if ((str[i-1] == '(')
                        &&(str[i-1] == '.')
                        &&(str[i-1] == '+')
                        &&(str[i-1] == '-')
                        &&(str[i-1] == '*')
                        &&(str[i-1] == '/')) {
                        check = false
                    }
                }

            }*/

            if (check)
            {
                calculateAll(str)
            }
            else
            {
                result.text = "error"
            }

        }

    }

    fun calculateAll(str: String) {

        var open = 0
        var close = 0
        var len = str.length
        var input = str

        for (j in 0 until len) {
            if (input[j] == ')') {
                close += 1
            }

            if (input[j] == '(') {
                open += 1
            }
        }
        if ((open == close)&&(open != 0)) {
            var i = 0
            while (i < len) {
                if (input[i] == ')') {

                    var k = i
                    while (input[k] != '(') {
                        k -= 1
                    }
                    val operation = input.substring(k + 1, i)
                    val part = purs(operation)

                    input = input.replace(input.substring(k, i + 1), part.toString())
                    len -= operation.length
                    i -= operation.length

                    calculateAll(input)

                }
                i++
            }
        } else if (open != close) {
            result.text = "error: invalid brackets"
            return
        }

        if (str == "")
        {
            result.text = ""
        }
        else
        {
            var finalRes = purs(input)
            input = input.replace(input, finalRes.toString())
            result.text = input
        }

    }

    fun purs(str: String) : Double
    {

        val parts = str.split("+","-","*","/")

        var signs = ""

        var count = 0
        var period = 0
        var minus = false



        while (count < str.length-parts[parts.size-1].length)
        {
            count += parts[period].length
            if (parts[period].length == 0)
            {
                if ((str[count + 1] != '-')&&(str[count + 1] != '+')&&(str[count + 1] != '*')&&(str[count + 1] != '/'))
                {
                   minus = true
                    count++
                }
            }
            else if (str[count + 1] == '-')
            {
                signs += str[count]
                count += 2
            }
            else
            {
                signs += str[count]
                count++
            }
            period++
        }

        var readyParts = parts.filter { it != "" }

        val partsDouble = Array(readyParts.size) { i -> readyParts[i].toDouble()}
        // result.text = signs

        var step = 0

        /*if (parts[0] == "-")
        {
            partsDouble[0] = -partsDouble[0]
            step++
        }*/

        for (i in 0..signs.length-1)
        {
            if (signs[i] == '*')
            {
                partsDouble[i] = partsDouble[i] * partsDouble[i+1]
                partsDouble[i+1] = partsDouble[i]
                step = i
            }
            if (signs[i] == '/')
            {
                partsDouble[i] = partsDouble[i] / partsDouble[i+1]
                partsDouble[i+1] = partsDouble[i]
                step = i
            }
        }

        for (i in 0..signs.length-1)
        {
            if (signs[i] == '+')
            {
                partsDouble[i] = partsDouble[i] + partsDouble[i+1]
                partsDouble[i+1] = partsDouble[i]
                step = i
            }
            if (signs[i] == '-')
            {
                partsDouble[i] = partsDouble[i] - partsDouble[i+1]
                partsDouble[i+1] = partsDouble[i]
                step = i
            }
        }


        if (minus)
        {
            return -partsDouble[step]
        }
        else
        {
            return partsDouble[step]
        }
    }

    fun setTextField(str: String) {
        operations.append(str)
    }

}
