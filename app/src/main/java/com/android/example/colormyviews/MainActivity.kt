/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.example.colormyviews

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * The colorMyViews app demonstrates how to use a ConstraintLayout using
 * the Layout Editor.
 */
class MainActivity : AppCompatActivity() {

    var count = 0
    var text = "Clicks: " + count
    lateinit var countNumber:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countNumber =  findViewById(R.id.click_count)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            changeNickname(it)
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }

        setListeners()

    }

    /**
     * Attaches listeners to all the views.
     */

    private fun setListeners(){
        val boxText = findViewById<TextView>(R.id.box)
        val box1Text = findViewById<TextView>(R.id.box1)
        val box2Text = findViewById<TextView>(R.id.box2)
        val box3Text = findViewById<TextView>(R.id.box3)
        val box4Text = findViewById<TextView>(R.id.box4)
        val box5Text = findViewById<TextView>(R.id.box5)
        val box6Text = findViewById<TextView>(R.id.box6)
        val box7Text = findViewById<TextView>(R.id.box7)
        val box8Text = findViewById<TextView>(R.id.box8)
        val box9Text = findViewById<TextView>(R.id.box9)
        val box10Text = findViewById<TextView>(R.id.box10)
        val box11Text = findViewById<TextView>(R.id.box11)
        val box12Text = findViewById<TextView>(R.id.box12)
        val box13Text = findViewById<TextView>(R.id.box13)
        val box14Text = findViewById<TextView>(R.id.box14)
        val box15Text = findViewById<TextView>(R.id.box15)
        val box16Text = findViewById<TextView>(R.id.box16)
        val box17Text = findViewById<TextView>(R.id.box17)
        val box18Text = findViewById<TextView>(R.id.box18)
        val box19Text = findViewById<TextView>(R.id.box19)
        val box20Text = findViewById<TextView>(R.id.box20)
        val box21Text = findViewById<TextView>(R.id.box21)
        val box22Text = findViewById<TextView>(R.id.box22)
        val box23Text = findViewById<TextView>(R.id.box23)
        val box24Text = findViewById<TextView>(R.id.box24)

        val retryButton = findViewById<TextView>(R.id.retry_button)

        val twoDimensional: List<List<View>> = listOf(
            listOf(boxText, box1Text, box2Text, box3Text, box4Text),
            listOf(box5Text, box6Text, box7Text, box8Text, box9Text),
            listOf(box10Text, box11Text, box12Text, box13Text, box14Text),
            listOf(box15Text, box16Text, box17Text, box18Text, box19Text),
            listOf(box20Text, box21Text, box22Text, box23Text, box24Text)
        )

        var indicator: Array<Array<Int>> = arrayOf<Array<Int>>()
        for (i in 0..4) {
            var array = arrayOf<Int>()
            for (j in 0..4) {
                array += 0
            }
            indicator += array
        }
        retryButton.setOnClickListener{retry(twoDimensional,indicator)}

        for(item: Int in (0..4)){
            for (item2: Int in(0..4)){
                twoDimensional[item][item2].setOnClickListener {flipLights(it,twoDimensional,item,item2,indicator)}
            }
        }
    }

    private fun flipLights(view: View,twodimensional : List<List<View>>,row:Int,col:Int,indicator:Array<Array<Int>> ){
            count ++
            text = "Clicks: " + count
            countNumber.setText(text)
           if(indicator[row][col] == 0) {
               view.setBackgroundColor(Color.BLACK)
               indicator[row][col] = 1
           }else{
               view.setBackgroundColor(Color.WHITE)
               indicator[row][col] = 0
           }

        if(row == 0) when (col){  //top
            0 -> { //left most
                if(indicator[row][col+1]==0) { //right white
                    twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                    indicator[row][col+1] = 1

                }else{ //right black
                    twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                    indicator[row][col+1] = 0
                }
                if(indicator[row+1][col]==0){ //down white
                    twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                    indicator[row+1][col] = 1
                }else{ //down black
                    twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                    indicator[row+1][col] = 0
                }
            }
            4 -> { //rightmost
                if(indicator[row][col-1]==0) { //left white
                    twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                    indicator[row][col-1] = 1
                }else{
                    twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                    indicator[row][col-1] = 0
                }
                if(indicator[row+1][col]==0){ //down white
                    twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                    indicator[row+1][col] = 1
                }else{
                    twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                    indicator[row+1][col] = 0
                }
            }
            else -> {
                if(indicator[row][col+1]==0) { //right white
                    twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                    indicator[row][col+1] = 1
                }else{
                    twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                    indicator[row][col+1] = 0
                }
                if(indicator[row][col-1]==0) { //left white
                    twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                    indicator[row][col-1] = 1
                }else{
                    twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                    indicator[row][col-1] = 0
                }
                if(indicator[row+1][col]==0){ //down white
                    twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                    indicator[row+1][col] = 1
                }else{
                    twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                    indicator[row+1][col] = 0
                }
            }
        }

        else if(row == 4) when (col){ //bottom
            0 -> { //left most
                if(indicator[row][col+1]==0) { //right white
                    twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                    indicator[row][col+1] = 1

                }else{ //right black
                    twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                    indicator[row][col+1] = 0
                }
                if(indicator[row-1][col]==0){ //up white
                    twodimensional[row+-1][col].setBackgroundColor(Color.BLACK)
                    indicator[row-1][col] = 1
                }else{ //up black
                    twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                    indicator[row-1][col] = 0
                }
            }
            4 -> { //rightmost
                if(indicator[row][col-1]==0) { //left white
                    twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                    indicator[row][col-1] = 1
                }else{
                    twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                    indicator[row][col-1] = 0
                }
                if(indicator[row-1][col]==0){ //up white
                    twodimensional[row-1][col].setBackgroundColor(Color.BLACK)
                    indicator[row-1][col] = 1
                }else{ //up black
                    twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                    indicator[row-1][col] = 0
                }
            }
            else -> {
                if(indicator[row][col+1]==0) { //right white
                    twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                    indicator[row][col+1] = 1
                }else{
                    twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                    indicator[row][col+1] = 0
                }
                if(indicator[row][col-1]==0) { //left white
                    twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                    indicator[row][col-1] = 1
                }else{
                    twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                    indicator[row][col-1] = 0
                }
                if(indicator[row-1][col]==0){ //up white
                    twodimensional[row-1][col].setBackgroundColor(Color.BLACK)
                    indicator[row-1][col] = 1
                }else{
                    twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                    indicator[row-1][col] = 0
                }
            }
        }

        if(col == 0) {  // left vertical
            if(row in 1..3) {
                if(indicator[row-1][col]==0){ //up white
                    twodimensional[row-1][col].setBackgroundColor(Color.BLACK)
                    indicator[row-1][col] = 1
                }else{ //up black
                    twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                    indicator[row-1][col] = 0
                }

                if(indicator[row+1][col]==0){ //down white
                    twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                    indicator[row+1][col] = 1
                }else{
                    twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                    indicator[row+1][col] = 0
                }

                if(indicator[row][col+1]==0) { //right white
                    twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                    indicator[row][col+1] = 1

                }else{ //right black
                    twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                    indicator[row][col+1] = 0
                }

            }
        }
        else if(col == 4){
            if(row in 1..3){
                if(indicator[row-1][col]==0){ //up white
                    twodimensional[row-1][col].setBackgroundColor(Color.BLACK)
                    indicator[row-1][col] = 1
                }else{ //up black
                    twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                    indicator[row-1][col] = 0
                }

                if(indicator[row+1][col]==0){ //down white
                    twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                    indicator[row+1][col] = 1
                }else{
                    twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                    indicator[row+1][col] = 0
                }

                if(indicator[row][col-1]==0) { //left white
                    twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                    indicator[row][col-1] = 1
                }else{
                    twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                    indicator[row][col-1] = 0
                }
            }
        }
        if(row in 1..3 && col in 1..3){ //middle
            if(indicator[row-1][col]==0){ //up white
                twodimensional[row-1][col].setBackgroundColor(Color.BLACK)
                indicator[row-1][col] = 1
            }else{ //up black
                twodimensional[row-1][col].setBackgroundColor(Color.WHITE)
                indicator[row-1][col] = 0
            }

            if(indicator[row+1][col]==0){ //down white
                twodimensional[row+1][col].setBackgroundColor(Color.BLACK)
                indicator[row+1][col] = 1
            }else{
                twodimensional[row+1][col].setBackgroundColor(Color.WHITE)
                indicator[row+1][col] = 0
            }

            if(indicator[row][col-1]==0) { //left white
                twodimensional[row][col-1].setBackgroundColor(Color.BLACK)
                indicator[row][col-1] = 1
            }else{
                twodimensional[row][col-1].setBackgroundColor(Color.WHITE)
                indicator[row][col-1] = 0
            }

            if(indicator[row][col+1]==0) { //right white
                twodimensional[row][col+1].setBackgroundColor(Color.BLACK)
                indicator[row][col+1] = 1

            }else{ //right black
                twodimensional[row][col+1].setBackgroundColor(Color.WHITE)
                indicator[row][col+1] = 0
            }
        }
    }

    private fun retry(twoDimensional : List<List<View>>,indicator:Array<Array<Int>>){

        for(item: Int in (0..4)){
            for (item2: Int in(0..4)){
                twoDimensional[item][item2].setBackgroundColor(Color.WHITE)
            }
        }

        for (i in 0..4) {
            for (j in 0..4) {
                indicator[i][j] = 0
            }
        }

        count = 0
    }

    private fun changeNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text

        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

    }
}

