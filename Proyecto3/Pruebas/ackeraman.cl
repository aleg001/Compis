class Ackermann {

  ackermann(m: Int, n: Int) : Int {
    {( let result : Int in
        if m=0 then result <- n+1 else
        if n=0 then result <- ackermann(m-1, 1) else
        result <- ackermann(m-1, ackermann(m, n-1))
      fi fi
    );}
  };

};

class Main inherits IO {
  ack: Ackermann;

  main() : SELF_TYPE {
    {
      ack <- new Ackermann;
      out_int(ack.ackermann(2, 3));
      self;
    }
  };
};
