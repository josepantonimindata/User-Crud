package me.team.usercrud.shared.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegexValidatorTest {
    
    @Test
    public void whenValueMatchesPattern_ThenReturnTrue() {
        String regex = "\\d+"; //match digits
        String testValue = "123";
        RegexValidator regexValidator = new RegexValidator(regex);
        
        assertTrue(regexValidator.validate(testValue), "The validate method should return true when value matches pattern.");
    }
    
    @Test
    public void whenValueDoesNotMatchPattern_ThenReturnFalse() {
        String regex = "\\d+"; //match digits
        String testValue = "ABC";
        RegexValidator regexValidator = new RegexValidator(regex);
    
        assertFalse(regexValidator.validate(testValue), "The validate method should return false when value does not match pattern.");
    }
    
    @Test
    public void whenValueIsEmptyAndPatternDoesNotMatch_ThenReturnFalse() {
        String regex = ".+"; //match any character at least once
        String testValue = "";
        RegexValidator regexValidator = new RegexValidator(regex);
    
        assertFalse(regexValidator.validate(testValue), "The validate method should return false for empty value when pattern expects at least one character.");
    }
    
    @Test
    public void whenValueIsEmptyAndPatternAllowEmpty_ThenReturnTrue() {
        String regex = ".*"; //match any character any number of times (including 0)
        String testValue = "";
        RegexValidator regexValidator = new RegexValidator(regex);
    
        assertTrue(regexValidator.validate(testValue), "The validate method should return true for empty value when pattern allows empty input.");
    }
}
