
public class Automate {
	private State currentState;//this variable is used to know the current state of the automaton. For example when we start to read the word, the value of the current state is q0
	private State transitionFunction[][]; //this variable contains the set of transitions of the automaton after reading a character
	private boolean knowThisWord;//this variable allows to know if the word is recognized by the automaton
	//default constructor
	public Automate(){
		this.transitionFunction = new State[4][2];
		this.transitionFunction[0][0] = State.q1;
		this.transitionFunction[0][1] = State.q2;
		this.transitionFunction[1][0] = State.q0;
		this.transitionFunction[1][1] = State.q3;
		this.transitionFunction[2][0] = State.q3;
		this.transitionFunction[2][1] = State.q2;
		this.transitionFunction[3][0] = State.q2;
		this.transitionFunction[3][1] = State.q3;
		this.knowThisWord = false;//At this moment We consider that the word is not recognized by the automaton 
	}
	//this method is used to get the current state 
	public State getCurrentState(){
		return this.currentState;
	}
	//this method is used to change or to update the value of the current state  
	public void SetCurrentState(State currentState){
		this.currentState = currentState;
	}
	//this method is used to get the type of the element
	public Type whatIsYourType(char element){
		if((int) element >= 48 && (int) element <= 57){
			return Type.number;
		}
		else{
			return Type.letter;
		} 
	}
	//this method is used to get the index of the state in the transition matrix
	public int getIndexByState(State state){
		if(state == State.q0){
			return 0;
		}
		else if(state == State.q1){
			return 1;
		}
		else if(state == State.q2){
			return 2;
		}
		else{
			return 3;
		}
		
	}
	//this method is used to get the next state after the character reading by the automaton
	public State getStateByElement(char element){
		int index,indexState;
		Type type; 
		State state;
		indexState = this.getIndexByState(this.currentState);
		type =  this.whatIsYourType(element);
		if (type == Type.number){
			index = 1;
		}
		else{
			index = 0;
		}
		state = this.transitionFunction[indexState][index];
		return state;
	}
	//this method is used for to read the characters contained in the word
	public void readWord(String word){
		this.currentState = State.q0;
		State s = null;;
		int i,size;
		size = word.length();
		System.out.print(this.getCurrentState() + " ");
		for(i = 0; i < size; i++){
			char c = word.charAt(i);
			s = this.getStateByElement(c);
			this.SetCurrentState(s);
			System.out.print(this.getCurrentState() + " ");
		}
		System.out.println("");
		if(this.currentState == State.q2){
			this.knowThisWord = true;
		}
		else{
			this.knowThisWord = false;
		}
		System.out.println("Result of the search---> " + this.getKnowWord());
		if(this.getKnowWord() == true){
			System.out.println(word + " is recognized by the automaton");
		}else{
			System.out.println(word + " is not recognized by the automaton");
		}
		System.out.println("");
	}
	//this method is used to know if the word is recognized by the automate or not
	public boolean getKnowWord(){
		return this.knowThisWord;
	}
}
