package com.fernandobarbosa.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val btnSelected = view as Button
        var cellId = 0

        when (btnSelected.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        playGame(cellId, btnSelected)
    }

    fun playGame(cellId: Int, btnSelected : Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.RED)
            player2.add(cellId)
            activePlayer = 1
        }

        btnSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player1.contains(3) && player1.contains(6) && player1.contains(6)) winner = 1

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner = 2
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner = 2
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) winner = 2
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner = 2
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner = 2
        if (player2.contains(3) && player2.contains(6) && player2.contains(6)) winner = 2

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this,  "Player 1 win the game!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,  "Player 2 win the game!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) emptyCells.add(cellId)
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells[randomIndex]

        var btnSelect: Button?

        when (cellId) {
            1 -> btnSelect = btn1
            2 -> btnSelect = btn2
            3 -> btnSelect = btn3
            4 -> btnSelect = btn4
            5 -> btnSelect = btn5
            6 -> btnSelect = btn6
            7 -> btnSelect = btn7
            8 -> btnSelect = btn8
            9 -> btnSelect = btn9
            else -> {
                btnSelect = btn1
            }
        }

        playGame(cellId, btnSelect)
    }
}
