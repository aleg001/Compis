class Main inherits IO {
    main() : IO {
        {
            io_out_int(add(3, 4));
            io_out_string("\n");
            io_out_int(divide(8, 2));
        }
    };

    add(x : Int, y : Int) : Int {
        x + y
    };

    divide(a : Int, b : Int) : Int {
        a / b
    };
};
