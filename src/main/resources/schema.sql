CREATE MEMORY TABLE "PUBLIC"."HCK_HISTORY_ITEMS"(
                                                    "ID" BINARY NOT NULL,
                                                    "HACK_PER_BUN" DECIMAL(19, 2),
                                                    "HACK_TOTAL" DECIMAL(19, 2),
                                                    "MODIFIED" DATE,
                                                    "NUMBER_OF_BUNS" DECIMAL(19, 2),
                                                    "NUMBER_OF_PERSONS" DECIMAL(19, 2),
                                                    "SAVED_TO_HISTORY" DATE
);
ALTER TABLE "PUBLIC"."HCK_HISTORY_ITEMS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.HCK_HISTORY_ITEMS;
CREATE MEMORY TABLE "PUBLIC"."HCK_WORKSPACES"(
                                                 "ID" BINARY NOT NULL,
                                                 "WORKSPACE" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."HCK_WORKSPACES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.HCK_WORKSPACES;
ALTER TABLE "PUBLIC"."HCK_WORKSPACES" ADD CONSTRAINT "PUBLIC"."UK_L33JDY906EFK9H4TOPC0YIFDB" UNIQUE("WORKSPACE");