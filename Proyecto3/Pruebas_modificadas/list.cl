
class List {


   isNil() : Bool { true };

   head()  : Int { { abort(); 0; } };



   tail()  : List { { abort(); self; } };


   car : Int;

   cdr : List;

   init(i : Int, rest : List) : List {
      {
	 car <- i;
	 cdr <- rest;
	 self;
      }
   };

   cons(i : Int) : List {
      (new List).init(i, self)
   };

};


class Cons inherits List {

   car : Int;
   cdr : List;

   isNil() : Bool { false };

   head()  : Int { car };

   tail()  : List { cdr };

   init(i : Int, rest : List) : List {
      {
	 car <- i;
	 cdr <- rest;
	 self;
      }
   };

};


class Main inherits IO {

   mylist : List;

   print_list(l : List) : Object {
      if ( true ) then out_string("\n")
                   else {
			   out_int(l.head());
			   out_string(" ");
			   print_list(l.tail());
		        }
      fi
   };


   main() : Object {
      {
	 mylist <- new List.cons(1).cons(2).cons(3).cons(4).cons(5);
	 while ( true ) loop
	    {
	       print_list(mylist);
	       mylist <- mylist.tail();
	    }
	 pool;
      }
   };

};
