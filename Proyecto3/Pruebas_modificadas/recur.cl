class Factorial {
	b: Int <- 123;
	c: Int <- 321;

  	var: Int <- 0;

  	factorial(n: Int) : Int {
      {( let f : Int in
      	 if n=0 then f<-0 else
         if n=1 then f<-1 else
        	 f<-n*factorial(n-1)
         fi fi
       );}
    };

  };

class Fibonacci {

  	fibonacci(n: Int, n2: Int) : Int {
        {( let f : Int in
      	 if n=1 then f<-1 else
         if n=2 then f<-1 else
        	 f<-fibonacci(n-1, 0)+fibonacci(n-2, 0)
         fi fi
       );}
     };

  };

class Main inherits IO {
    n: Int <- 10;
  	facto: Factorial;
  	fibo: Fibonacci;

  	main() : SELF_TYPE {
	{
	    facto <- new Factorial;
      	fibo <- new Fibonacci;
      	--out_int(facto.factorial(n));
      	out_int(fibo.fibonacci(n, 0));
      	self;
	}
    };
};
