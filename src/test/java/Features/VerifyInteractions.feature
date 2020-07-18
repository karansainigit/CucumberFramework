@Interactions
  Feature: Verify Interaction on Demo QA Website

    Scenario: Verify Simple Droppable functionality
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Droppable
      And User performs simple drag and drop
      Then Drag and Drop should be performed successfully

    Scenario: Verify Acceptable Droppable functionality
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Droppable
      And User drag and drop Acceptable drag box
      Then Acceptable Drag and Drop should be performed successfully

    Scenario: Verify Not Acceptable Droppable functionality
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Droppable
      And User drag and drop Not Acceptable drag box
      Then Verify Not Acceptable drag and drop

    Scenario: Verify Sortable on Demo QA Website
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Sortable
      Then User verifies that elements in the list are sorted

    Scenario: Verify Selectable on Demo QA Website
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Selectable
      And User Selects from the list
      Then Selected should be highlighted

    Scenario: Verify Resizable on Demo QA Website
      Given User go to "https://demoqa.com/interaction" website
      When User clicks on Resizable
      And User resize the box
      Then Verify box is resized