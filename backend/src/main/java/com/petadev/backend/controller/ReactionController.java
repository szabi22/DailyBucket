package com.petadev.backend.controller;
import com.petadev.backend.controller.dao.DaoStore;
import com.petadev.backend.entity.Reaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
@RestController
public class ReactionController {


        private static final Logger LOG = LoggerFactory.getLogger(ReactionController.class);

        @GetMapping("/reactions/{reactionId}")
        public Reaction getReactionById(@PathVariable Integer reactionId) throws SQLException {
            LOG.info("Sending reaction by id");
            return DaoStore.getReactionDao().queryForId(reactionId);
        }
    }

