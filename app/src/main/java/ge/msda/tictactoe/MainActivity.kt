package ge.msda.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var scoreFirst = 0;
    private var scoreSecond = 0;

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.init()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList("firstPlayer", firstPlayer)
        outState.putIntegerArrayList("secondPlayer", secondPlayer)

        outState.putInt("scoreFirst", scoreFirst)
        outState.putInt("scoreSecond", scoreSecond)

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        firstPlayer = savedInstanceState.getIntegerArrayList("firstPlayer")!!;
        secondPlayer = savedInstanceState.getIntegerArrayList("secondPlayer")!!;

        scoreFirst = savedInstanceState.getInt("scoreFirst")
        scoreSecond = savedInstanceState.getInt("scoreSecond")

        for (i in firstPlayer) {
            var resId = getResources().getIdentifier("button" + i, "id", getPackageName());
            var button = findViewById<Button>(resId);

            button.isEnabled = false;
            button.text = "X"
            button.setBackgroundColor(Color.RED)
        }

        for (i in secondPlayer) {
            var resId = getResources().getIdentifier("button" + i, "id", getPackageName());
            var button = findViewById<Button>(resId);

            button.isEnabled = false;
            button.text = "0"
            button.setBackgroundColor(Color.BLUE)
        }

        scoreA.text = scoreFirst.toString()
        scoreB.text = scoreSecond.toString()


        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun init() {

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener {

            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true

            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""

            button1.setBackgroundColor(Color.GRAY)
            button2.setBackgroundColor(Color.GRAY)
            button3.setBackgroundColor(Color.GRAY)
            button4.setBackgroundColor(Color.GRAY)
            button5.setBackgroundColor(Color.GRAY)
            button6.setBackgroundColor(Color.GRAY)
            button7.setBackgroundColor(Color.GRAY)
            button8.setBackgroundColor(Color.GRAY)
            button9.setBackgroundColor(Color.GRAY)

            this.firstPlayer.clear()
            this.secondPlayer.clear()

            this.activePlayer = 1

        }

    }


    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0) {
                playGame(buttonNumber, clickedView)
            }

        }

    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            this.firstPlayer.add(buttonNumber)
            activePlayer = 2
            clickedView.setBackgroundColor(Color.RED)
        } else {
            clickedView.text = "0"
            this.secondPlayer.add(buttonNumber)
            activePlayer = 1
            clickedView.setBackgroundColor(Color.BLUE)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }


        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(applicationContext, "X wins!", Toast.LENGTH_LONG).show()
                scoreFirst++
                scoreA.text = scoreFirst.toString()

            } else {
                Toast.makeText(applicationContext, "0 wins!", Toast.LENGTH_LONG).show()
                scoreSecond++
                scoreB.text = scoreSecond.toString()

            }
        } else {
            if (this.firstPlayer.size + this.secondPlayer.size == 9) {
                Toast.makeText(applicationContext, "ფრე!", Toast.LENGTH_LONG).show()
            }
        }

    }

}