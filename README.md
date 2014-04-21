# Ruzzle Solver

A solver for the [Ruzzle][1] game, written in Clojure.

## Usage

- Clone this repo
- Compile by running `lein uberjar`
- Run with `lein run <board_size> <board>`

## Options

- For a 4x4 board, the `board_size` is 4.
- Enter `board` as a string of capital letters.

## Example

![Example Ruzzle Board](https://raw.githubusercontent.com/timothyandrew/ruzzle-solver/master/resources/example.png)

- For this board, you would run the solver with:

```bash
$ lein run 4 OTIREKANADNNDLEN
```

## License

Copyright © 2014 Timothy Andrew

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[1]: http://www.ruzzle-game.com/
