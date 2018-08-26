package first

class OptionalParameter {
	//Groovy allows to have optional parameter values. Optional parameter values are indicated by =0.
	static sum(a,b,c=0){
		a+b+c;
		}

	static main(args) {
				println sum(1,5)
				println sum(1,2,5)
				}
}
