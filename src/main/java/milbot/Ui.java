package milbot;

import extensions.Tag;
import extensions.TagList;
import taskclasses.Task;
import taskclasses.Deadline;
import taskclasses.Event;

/**
 * Ui class handles user interface-related functionalities.
 */
public class Ui {
    /**
     * Prints a goodbye message before the chatbot exits.
     *
     * @return the goodbye message.
     */

    public String printGoodbyeMessage() {
        return "Have a nice day and see you again soon!";
    }

    /**
     * Prints an error message.
     *
     * @param message The error message to be printed.
     */

    public String printErrorMessage(String message) {
        return message + "\n";
    }


    /**
     * Prints a message indicating a new task has been added to the task list.
     *
     * @param taskList The TaskList containing the added task.
     * @param task     The added task.
     *
     * @return add new task message.
     */

    public String printNewTask(TaskList taskList, Task task) {
        String newTaskMessage = "Got it. I've added this task:\n" +
                "  " + task + "\n" +
                "Now you have " + taskList.getSize() + " tasks in the list.\n";

        return newTaskMessage;
    }


    /**
     * Prints the list of tasks.
     *
     * @param taskList The TaskList containing the tasks to be printed.
     * @return A message containing the task list.
     */

    public String printTaskList(TaskList taskList) {
        String taskListMessage = "Here are the tasks in your list:\n";
        int i = 1;
        for (Task task : taskList.getTaskList()) {
            taskListMessage += String.format("%d. %s\n", i, task.toString());
            i++;
        }
        return taskListMessage;
    }


    /**
     * Prints a message indicating that a task has been marked as done.
     *
     * @param task The task that has been marked as done.
     * @return A message indicating that the task has been marked as done.
     */

    public String printMarkTask(Task task) {
        return "Nice! I've marked this task as done:\n" + task;
    }

    /**
     * Prints a message indicating that a task has been marked as not done yet.
     *
     * @param task The task that has been marked as not done yet.
     * @return A message indicating that the task has been marked as undone.
     */

    public String printUnmarkTask(Task task) {
        return "OK, I've marked this task as not done yet:\n" + task;
    }


    /**
     * Prints a message indicating that a task has been removed from the task list.
     *
     * @param task     The task that has been removed.
     * @param taskList The TaskList after the task has been removed.
     * @return A message indicating that the task has been removed.
     */

    public String printRemoveTask(Task task, TaskList taskList) {
        return "Noted. I've removed this task:\n" + task + "\n" +
                "Now you have " + taskList.getSize() + " tasks in the list.";
    }

    /**
     * Prints a message indicating an unknown command.
     *
     * @return A message indicating that the user command is unknown.
     */
    public String printUnknownMessage() {
        return "Oopsie! I'm sorry, but I don't know what that means :(";
    }

    /**
     * Generates a message containing tasks that match the search query.
     *
     * @param taskList The task list to search within.
     * @return A message of tasks that match the search query, or no matches found.
     */
    public String printSearchResult(TaskList taskList) {
        if (taskList.getSize() == 0) {
            return "There is no task matched to your query";
        }

        String searchResult = "Here are the matching tasks in your list:\n";
        int i = 1;

        for (Task task : taskList.getTaskList()) {
            searchResult += String.format("%d.%s \n", i, task.toString());
            i++;
        }

        return searchResult;
    }

    public String printNewTag(TagList tagList, Tag tag) {
        String newTagMessage = "Got it. I've added this tag:\n" +
                "  " + tag + "\n" +
                "Now you have " + tagList.getSize() + " tags.\n";

        return newTagMessage;
    }

    public String printRemoveTag(Tag tag, TagList tagList) {
        return "Noted. I've removed this tag:\n" + tag + "\n" +
                "Now you have " + tagList.getSize() + " tags.";
    }

    public String printTagList(TagList tagList) {
        String taskListMessage = "Here are the tags you have:\n";
        int i = 1;
        for (Tag tag : tagList.getTagList()) {
            taskListMessage += String.format("%d. %s\n", i, tag.toString());
            i++;
        }
        return taskListMessage;

    }

    public String printTagTask(Task task) {
        return "Nice! I've tagged this task:\n" + task.toString();
    }
    public String printUntagTask(Task task) {
        return "Nice! I've untagged this task:\n" + task;
    }
}
