package com.clavisoft.studentx.cli;

/**
 * Handle all the logic of CLI
 */
public abstract class StudentCLI {
    /**
     * The arguments
     */
    protected String[] args;

    /**
     * Validate arguments (e.g.name=)
     *
     * @return
     */
    protected abstract String validateParameters();

    /**
     * Filter values based on the request
     * @return The response
     */
    public abstract String filter();
}
