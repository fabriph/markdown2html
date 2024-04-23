
# DESIGN
 - Seems like it processes the file line by line.
 - Assume plain text file type for I/O.
 - ASCII

## Options considered
- Custom-built algorithm that crawls individual characters
- RegEx

#### Nits
- RegEx and sed would work well. The configs of RegEx could be defined in a plain text file and executed one by one via sed.

## Implementation
Discussion of implementation details and tradeoffs.

- Read regex from a config file.
- Java implementation is going to be easier to maintain and extend.
- Performance: - RegEx are in most cases more expensive than processing the file character by character.

#### Limitations
- What if the file is too big to fit in memory?

# SUCCESS CRITERIA

### Functionality
- Does the code do what it should?
- Does it handle edge cases?

### Code quality
- Is the code readable & maintainable?
- Is there reasonable test coverage?

### Performance
- Does the code balance reasonably fast execution with readability?
- Can the implementation handle large inputs gracefully?

### Pragmatism
- Are the above factors balanced well against the limited time to implement the solution?
