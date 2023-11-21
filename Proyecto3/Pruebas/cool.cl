class Fibonacci {

  	fibonacci(n: Int) : Int {
        {( let f : Int in
      	 if n=1 then f<-1 else
         if n=2 then f<-1 else
        	 f<-fibonacci(n-1)+fibonacci(n-2)
         fi fi
       );}
     };

  };

class Main inherits IO {
    main() : SELF_TYPE {
	{
	    out_string((new Fibonacci).type_name().substr(1,1));
	    -- out_string((new Factorial).type_name().substr(1,1));
	    -- out_string("\n");
	    -- out_string(("palabra").type_name().substr(5,8));
	}
    };
};