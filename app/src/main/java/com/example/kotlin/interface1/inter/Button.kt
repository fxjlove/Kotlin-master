package com.example.kotlin.interface1.inter

class Button : View{
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    //这个类与java中的静态嵌套类类似
    class ButtonState : State{

    }
}